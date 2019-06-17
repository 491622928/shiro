package com.yyz.entity;

import java.util.Date;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysOrder)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_order")
public class SysOrder extends TailBean implements Serializable {
    private static final long serialVersionUID = -17362492608414873L;
    private Integer orderId;
    private String orderCode;
    private Date orderCreTim;
    private Object orderStaTim;
    private Object orderEndTim;
    /**
     * 租金
     */
    private Integer orderRental;
    private Integer orderRoom;
    private Integer orderUse;
    /**
     * 0.完成 1.未完成
     */
    private Integer orderType;

}