package com.yyz.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysRoleUser)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_role_user")
public class SysRoleUser extends TailBean implements Serializable {
    private static final long serialVersionUID = 218821690324413242L;
    private Integer id;
    private Integer userId;
    private Integer roleId;

}