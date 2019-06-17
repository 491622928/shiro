package com.yyz.service;

import java.util.List;

import com.yyz.entity.SysRoom;
import com.yyz.dao.SysRoomDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * (SysRoom)表服务
 *
 * @author makejava
 * create on 2019-06-11 15:08:04
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysRoomService {
    private final SysRoomDao sysRoomDao;

    public SysRoom queryById(Integer id) {
        return sysRoomDao.single(id);
    }

    public List<SysRoom> queryAll() {
        return sysRoomDao.all();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert(SysRoom sysRoom) {
        sysRoomDao.insert(sysRoom, true);
    }
    
    /**
     * 根据主键更新记录
     *
     * @param sysRoom 待更新的记录.包含主键在内，如果其他列的值为空则不更新
     * @return 成功返回true，失败返回false
     */
    public boolean updateById(SysRoom sysRoom) {
        return sysRoomDao.updateTemplateById(sysRoom) > 0;
    }
    
    /**
     * 根据主键删除记录
     *
     * @param id 主键
     * @return 成功返回true，反之返回false
     */
    public boolean deleteById(Integer id) {
        return sysRoomDao.deleteById(id) > 0;
    }
    
    /**
     * 分页查询
     * @param pageQuery 封装分页条件的分页对象
     * @return pageQuery 作为一个引用，将查询结果封装进去
     */
    public PageQuery<SysRoom> queryByPage(PageQuery<SysRoom> pageQuery) {
        sysRoomDao.queryByPage(pageQuery);
        return pageQuery;
    }
}