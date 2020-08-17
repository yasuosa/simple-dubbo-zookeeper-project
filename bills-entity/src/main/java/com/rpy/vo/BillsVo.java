package com.rpy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 18:36
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillsVo implements Serializable {

    private Integer page;
    private Integer limit;

    private Integer typeId;

    private Date startTime;

    private Date endTime;
}
