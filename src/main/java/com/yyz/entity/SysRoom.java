package com.yyz.entity;

import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysRoom)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_room")
public class SysRoom extends TailBean implements Serializable {
    private static final long serialVersionUID = -45612075334491979L;
    private Integer roomId;
    private String roomAddr;
    /**
     * 0可租， 1在租
     */
    private Integer roomHold;
    /**
     * 房东
     */
    private Integer roomUse;

}