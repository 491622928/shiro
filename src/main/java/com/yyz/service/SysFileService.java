package com.yyz.service;

import java.util.List;

import com.yyz.entity.SysFile;
import com.yyz.dao.SysFileDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * (SysFile)表服务
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysFileService {
    private final SysFileDao sysFileDao;

    public SysFile queryById(Integer id) {
        return sysFileDao.single(id);
    }

    public List<SysFile> queryAll() {
        return sysFileDao.all();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert(SysFile sysFile) {
        sysFileDao.insert(sysFile, true);
    }
    
    /**
     * 根据主键更新记录
     *
     * @param sysFile 待更新的记录.包含主键在内，如果其他列的值为空则不更新
     * @return 成功返回true，失败返回false
     */
    public boolean updateById(SysFile sysFile) {
        return sysFileDao.updateTemplateById(sysFile) > 0;
    }
    
    /**
     * 根据主键删除记录
     *
     * @param id 主键
     * @return 成功返回true，反之返回false
     */
    public boolean deleteById(Integer id) {
        return sysFileDao.deleteById(id) > 0;
    }
    
    /**
     * 分页查询
     * @param pageQuery 封装分页条件的分页对象
     * @return pageQuery 作为一个引用，将查询结果封装进去
     */
    public PageQuery<SysFile> queryByPage(PageQuery<SysFile> pageQuery) {
        sysFileDao.queryByPage(pageQuery);
        return pageQuery;
    }
}