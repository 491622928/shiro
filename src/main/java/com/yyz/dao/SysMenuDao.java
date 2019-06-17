package com.yyz.dao;

import com.yyz.entity.SysMenu;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

/**
 * (SysMenu)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Repository
@SqlResource("SysMenu.md")
public interface SysMenuDao extends BaseMapper<SysMenu> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysMenu> pageQuery);
}