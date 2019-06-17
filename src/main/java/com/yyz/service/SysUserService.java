package com.yyz.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import com.yyz.dao.*;
import com.yyz.entity.*;
import com.yyz.vo.RoleVO;
import com.yyz.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * (SysUser)表服务
 *
 * @author makejava
 * create on 2019-06-11 15:08:04
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysUserService {
    private final SysUserDao sysUserDao;

    private final SysRoleUserDao sysRoleUserDao;

    private final SysRoleDao sysRoleDao;

    private final SysRoleMenuDao sysRoleMenuDao;

    private final SysMenuDao sysMenuDao;

    public SysUser queryById(Integer id) {
        return sysUserDao.single(id);
    }

    public List<SysUser> queryAll() {
        return sysUserDao.all();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert(SysUser sysUser) {
        sysUserDao.insert(sysUser, true);
    }

    /**
     * 根据主键更新记录
     *
     * @param sysUser 待更新的记录.包含主键在内，如果其他列的值为空则不更新
     * @return 成功返回true，失败返回false
     */
    public boolean updateById(SysUser sysUser) {
        return sysUserDao.updateTemplateById(sysUser) > 0;
    }

    /**
     * 根据主键删除记录
     *
     * @param id 主键
     * @return 成功返回true，反之返回false
     */
    public boolean deleteById(Integer id) {
        return sysUserDao.deleteById(id) > 0;
    }

    /**
     * 分页查询
     *
     * @param pageQuery 封装分页条件的分页对象
     * @return pageQuery 作为一个引用，将查询结果封装进去
     */
    public PageQuery<SysUser> queryByPage(PageQuery<SysUser> pageQuery) {
        sysUserDao.queryByPage(pageQuery);
        return pageQuery;
    }

    public UserVO getUserVO(Integer userId) {
        UserVO userVO = new UserVO();
        RoleVO roleVO = new RoleVO();
        SysUser user = sysUserDao.single(userId);
        /*获取角色id列表*/
        List<SysRoleUser> roleUserList = sysRoleUserDao.createLambdaQuery()
                .andEq(SysRoleUser::getUserId, user.getUserId())
                .select();
        if (roleUserList.size() != 0) {

            /*获取角色列表*/
            Collection<Integer> roleIds = roleUserList.stream().map(e -> e.getRoleId()).collect(Collectors.toList());
            List<SysRole> sysRoleList = sysRoleDao.createLambdaQuery()
                    .andIn(SysRole::getRoleId, roleIds)
                    .select();

            Set<RoleVO> roleVOSet = new HashSet<>();
            sysRoleList.stream().forEach(SysRole -> {
                BeanUtils.copyProperties(SysRole, roleVO);
                /*获取权限id列表*/
                List<SysRoleMenu> sysRoleMenuList = sysRoleMenuDao.createLambdaQuery()
                        .andEq(SysRoleMenu::getRoleId, roleVO.getRoleId())
                        .select();
                if (sysRoleMenuList.size() != 0) {
                    /*获取权限列表*/
                    Collection<Integer> menuIds = sysRoleMenuList.stream().map(e -> e.getMenuId()).collect(Collectors.toList());
                    List<SysMenu> menuList = sysMenuDao.createLambdaQuery()
                            .andIn(SysMenu::getMenuId, menuIds)
                            .select();
                    Set<SysMenu> sysMenuSet = new HashSet<>();
                    menuList.stream().forEach(SysMenu -> sysMenuSet.add(SysMenu));
                    roleVO.setSysMenuSet(sysMenuSet);
                    roleVOSet.add(roleVO);
                }
            });
            BeanUtils.copyProperties(user, userVO);
            userVO.setRoleSet(roleVOSet);
        }
        return userVO;
    }

    public SysUser getUserByAccount(String userAccount) {
        return sysUserDao.createQuery().andEq("user_account", userAccount).single();
    }
}