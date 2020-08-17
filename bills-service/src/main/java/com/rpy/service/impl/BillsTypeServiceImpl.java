package com.rpy.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rpy.common.DataGridView;
import com.rpy.mapper.BillTypeMapper;
import com.rpy.service.BillsTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 20:42
 **/

@Service
public class BillsTypeServiceImpl  implements BillsTypeService {

    @Autowired
    private BillTypeMapper billTypeMapper;


    @Override
    @HystrixCommand
    public DataGridView queryAllBillsType() {
        return new DataGridView(200,"操作成功",0L,billTypeMapper.selectList(null));
    }
}
