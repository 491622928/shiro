package com.yyz.controller;


import com.benyun.boot.core.vo.ResultVO;
import com.benyun.boot.core.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import com.yyz.entity.SysRoleMenu;
import com.yyz.service.SysRoleMenuService;
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

import java.util.List;

/**
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@RestController
@RequestMapping("sysRoleMenu")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SysRoleMenuController {
    /**
     * 服务对象
     */
    private final SysRoleMenuService sysRoleMenuService;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAll/all")
    public ResultVO<?> queryAll() {
        return ResultUtil.success(sysRoleMenuService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryOne/{id}")
    public ResultVO<?> queryOne(@PathVariable Integer id) {
        return ResultUtil.success(sysRoleMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实体对象
     * @return 新增结果
     */
    @PostMapping("/create")
    public ResultVO<?> create(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.insert(sysRoleMenu);
        return ResultUtil.success();
    }

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResultVO<?> update(@RequestBody SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.updateById(sysRoleMenu) ? ResultUtil.success() : ResultUtil.failure();
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResultVO<?> delete(@RequestParam("idList") List<Long> idList) {
      //  return success(this.sysRoleMenuService.removeByIds(idList));
      return ResultUtil.success();
    }
}