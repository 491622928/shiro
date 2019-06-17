package com.yyz.dao;

import com.yyz.entity.SysRole;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

/**
 * (SysRole)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@Repository
@SqlResource("SysRole.md")
public interface SysRoleDao extends BaseMapper<SysRole> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysRole> pageQuery);
}