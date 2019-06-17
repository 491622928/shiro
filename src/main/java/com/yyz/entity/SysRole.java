package com.yyz.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_role")
public class SysRole extends TailBean implements Serializable {
    private static final long serialVersionUID = 896627442921329456L;
    private Integer roleId;
    private String roleName;

}