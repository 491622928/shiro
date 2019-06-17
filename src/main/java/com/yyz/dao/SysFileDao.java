package com.yyz.dao;

import com.yyz.entity.SysFile;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.springframework.stereotype.Repository;

/**
 * (SysFile)表数据库访问层
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Repository
@SqlResource("SysFile.md")
public interface SysFileDao extends BaseMapper<SysFile> {
    /**
     * 分页查询
     */
    void queryByPage(PageQuery<SysFile> pageQuery);
}