package com.yyz.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_menu")
public class SysMenu extends TailBean implements Serializable {
    private static final long serialVersionUID = 974410964036777970L;
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    /**
     * 父类
     */
    private Integer menuFather;
    /**
     * 标识
     */
    private Integer menuLevel;
    /**
     * 权限
     */
    private String menuOther;

}