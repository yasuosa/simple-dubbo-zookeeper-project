package com.rpy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bills")
public class Bills implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "title")
    private String title;

    @TableField(value = "billtime")
    private Date billtime;

    @TableField(value = "typeid")
    private Integer typeid;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private String typeName;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_BILLTIME = "billtime";

    public static final String COL_TYPEID = "typeid";

    public static final String COL_PRICE = "price";

    public static final String COL_REMARK = "remark";
}