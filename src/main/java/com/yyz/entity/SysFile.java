package com.yyz.entity;

import java.util.Date;
import lombok.*;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import java.io.Serializable;

/**
 * (SysFile)实体类
 *
 * @author makejava
 * create on 2019-06-11 15:08:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "sys_file")
public class SysFile extends TailBean implements Serializable {
    private static final long serialVersionUID = 813850595966297424L;
    private Integer fileId;
    private String fileName;
    private String fileUrl;
    private Date fileCreTim;
    private Integer fileRoom;
    private Integer fileOrder;
    /**
     * 0.文件 1.图片
     */
    private Integer fileUse;
    private Integer fileType;

}