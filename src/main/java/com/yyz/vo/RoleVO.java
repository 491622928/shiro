package com.yyz.vo;

import com.yyz.entity.SysMenu;
import lombok.Data;

import java.util.Set;

/**
 * @author 一卓
 * @ClassName: RoleVO
 * @description: TODO
 * @date 2019/6/5 16:18
 */
@Data
public class RoleVO {

    private Integer roleId;
    private String roleName;
    /**
     * 权限
     */
    private Set<SysMenu> sysMenuSet;
}
