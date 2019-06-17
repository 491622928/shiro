package com.yyz.controller;


import com.benyun.boot.core.vo.ResultVO;
import com.benyun.boot.core.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import com.yyz.entity.SysUser;
import com.yyz.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * create on 2019-06-11 15:08:04
 */
@RestController
@RequestMapping("sysUser")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})

public class SysUserController {
    /**
     * 服务对象
     */
    private final SysUserService sysUserService;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */

    @GetMapping("/queryAll/all")
    @RequiresPermissions("use_find_all")
    public ResultVO<?> queryAll() {
        return ResultUtil.success(sysUserService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryOne/{id}")
    public ResultVO<?> queryOne(@PathVariable Integer id) {
        return ResultUtil.success(sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping("/create")
    public ResultVO<?> create(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return ResultUtil.success();
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResultVO<?> update(@RequestBody SysUser sysUser) {
        return sysUserService.updateById(sysUser) ? ResultUtil.success() : ResultUtil.failure();
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResultVO<?> delete(@RequestParam("idList") List<Long> idList) {
      //  return success(this.sysUserService.removeByIds(idList));
      return ResultUtil.success();
    }
}