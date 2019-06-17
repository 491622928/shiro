package com.yyz.dao;

import com.yyz.entity.SysRoom;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

/**
 * (SysRoom)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:04
 */
@Repository
@SqlResource("SysRoom.md")
public interface SysRoomDao extends BaseMapper<SysRoom> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysRoom> pageQuery);
}