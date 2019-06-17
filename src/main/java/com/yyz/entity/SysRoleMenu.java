package com.yyz.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_role_menu")
public class SysRoleMenu extends TailBean implements Serializable {
    private static final long serialVersionUID = -70469897938438979L;
    private Integer id;
    private Integer roleId;
    private Integer menuId;

}