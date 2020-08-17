package com.rpy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rpy.common.DataGridView;
import com.rpy.domain.BillType;
import com.rpy.domain.Bills;
import com.rpy.mapper.BillTypeMapper;
import com.rpy.mapper.BillsMapper;
import com.rpy.service.BillService;
import com.rpy.vo.BillsVo;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 20:34
 **/

@Service(methods = {
        // 非幂等 不重试
        @Method(name ="addBills",retries = -1)
})
public class BillServiceImpl implements BillService {

    @Autowired
    private BillsMapper billsMapper;

    @Autowired
    private BillTypeMapper billTypeMapper;

    @Override
    @HystrixCommand
    public DataGridView queryAllBills(BillsVo billsVo) {
        QueryWrapper<Bills> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(billsVo.getTypeId() != null,"typeid",billsVo.getTypeId());
        queryWrapper.ge(billsVo.getStartTime() !=null,"billtime",billsVo.getStartTime())
                .le(billsVo.getEndTime() != null,"billtime",billsVo.getEndTime())
                .orderByDesc("billtime");


        IPage<Bills> page=new Page<>(billsVo.getPage(),billsVo.getLimit());
        billsMapper.selectPage(page,queryWrapper);
        DataGridView data=new DataGridView();
        data.setCode(200);
        data.setMsg("操作成功");
        data.setCount(page.getTotal());
        List<Bills> records = page.getRecords();
        records.forEach(e ->{
            BillType billType = billTypeMapper.selectById(e.getTypeid());
            if(null !=billType) {
                e.setTypeName(billType.getName());
            }
        });
        data.setData(records);
        return data;
    }

    @Override
    @HystrixCommand
    public int addBills(Bills bills) {
        return billsMapper.insert(bills);
    }
}
