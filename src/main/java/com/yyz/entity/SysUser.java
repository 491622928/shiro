package com.yyz.entity;

import java.util.Date;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_user")
public class SysUser extends TailBean implements Serializable {


    private static final long serialVersionUID = -6616476309215807398L;
    private Integer userId;
    private String userName;
    /**
     * 身份证号
     */
    private String userIdc;
    /**
     * 0 女 1 男
     */
    private Integer userSex;
    private String userAge;
    private String userTel;
    /**
     * 账号
     */
    private String userAccount;
    private String userPassword;
    private Date userCreTim;
    private Date useUpdTim;


}