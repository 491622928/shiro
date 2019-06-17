package com.yyz.vo;

import lombok.Data;

import java.util.Set;

/**
 * @author 一卓
 * @ClassName: UserVO
 * @description: TODO
 * @date 2019/6/5 11:11
 */
@Data
public class UserVO {


    private Integer userId;
    private String userName;
    private String userAccount;
    /**
     * 角色
     */
    private Set<RoleVO> roleSet;

}
