package com.yyz.controller;


import com.benyun.boot.core.vo.ResultVO;
import com.benyun.boot.core.util.ResultUtil;
import com.yyz.entity.SysUser;
import com.yyz.service.SysUserService;
import com.yyz.vo.UserVO;
import lombok.RequiredArgsConstructor;
import com.yyz.entity.SysMenu;
import com.yyz.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@RestController
@RequestMapping("sysMenu")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysMenuController {
    /**
     * 服务对象
     */
    private final SysMenuService sysMenuService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAll/all")
    public ResultVO<?> queryAll() {
        return ResultUtil.success(sysMenuService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryOne/{id}")
    public ResultVO<?> queryOne(@PathVariable Integer id) {
        return ResultUtil.success(sysMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @PostMapping("/create")
    public ResultVO<?> create(@RequestBody SysMenu sysMenu) {
        sysMenuService.insert(sysMenu);
        return ResultUtil.success();
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResultVO<?> update(@RequestBody SysMenu sysMenu) {
        return sysMenuService.updateById(sysMenu) ? ResultUtil.success() : ResultUtil.failure();
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResultVO<?> delete(@RequestParam("idList") List<Long> idList) {
        //  return success(this.sysMenuService.removeByIds(idList));
        return ResultUtil.success();
    }

    @GetMapping("/getMenu")
    public ResultVO<?> getMenuByUser() {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        UserVO userVO = sysUserService.getUserVO(sysUser.getUserId());
        Set<SysMenu> sysMenuSet = new HashSet<>();
        userVO.getRoleSet().stream().forEach(RoleVO -> {
            RoleVO.getSysMenuSet().stream().forEach(SysMenu -> {
                if (!sysMenuSet.contains(SysMenu))
                    sysMenuSet.add(SysMenu);
            });
        });
        return ResultUtil.success(sysMenuSet);
    }
}