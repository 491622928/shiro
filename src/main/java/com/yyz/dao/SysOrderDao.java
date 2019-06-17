package com.yyz.dao;

import com.yyz.entity.SysOrder;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

/**
 * (SysOrder)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Repository
@SqlResource("SysOrder.md")
public interface SysOrderDao extends BaseMapper<SysOrder> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysOrder> pageQuery);
}