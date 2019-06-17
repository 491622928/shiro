package com.yyz.service;

import com.yyz.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 一卓
 * @ClassName: SysUserServiceTest
 * @description: TODO
 * @date 2019/6/12 11:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;
    @Test
    public void getUserByAccount() {
        SysUser result = sysUserService.getUserByAccount("admin");
        Assert.assertNotNull(result);
    }
}