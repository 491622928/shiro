package com.yyz.dao;

import com.yyz.entity.SysRole;
import com.yyz.entity.SysRoleUser;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysRoleUser)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@Repository
@SqlResource("SysRoleUser.md")
public interface SysRoleUserDao extends BaseMapper<SysRoleUser> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysRoleUser> pageQuery);

    List<SysRoleUser> getRoleByUserId(Integer userId);
}