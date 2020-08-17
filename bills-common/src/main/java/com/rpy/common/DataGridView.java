package com.rpy.common;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: bills
 * @description: 前端返回值模型
 * @author: 任鹏宇
 * @create: 2020-08-17 17:26
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView  implements Serializable {

    private Integer code;
    private String msg="";
    private Long count=0L;
    private Object data;

}
