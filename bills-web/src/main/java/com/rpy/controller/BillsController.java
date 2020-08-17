package com.rpy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rpy.common.DataGridView;
import com.rpy.domain.Bills;
import com.rpy.service.BillService;
import com.rpy.vo.BillsVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 21:47
 **/

@RestController
@RequestMapping("api")
public class BillsController {

    @Reference
    private BillService billService;


    /**
     * 查询所有账单
     */

    @RequestMapping(value = "bills/loadAllBills",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "loadAllBillsError")
    public DataGridView loadAllBills(@RequestBody BillsVo billsVo){
        return this.billService.queryAllBills(billsVo);
    }

    public DataGridView loadAllBillsError(@RequestBody BillsVo billsVo){
        return new DataGridView();
    }

    @RequestMapping(value = "bills/addBills",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "addBillsError")
    public DataGridView addBills(@RequestBody Bills bills){
        int num = billService.addBills(bills);
        DataGridView dataGridView = new DataGridView();
        dataGridView.setCode(num ==0 ?-1:0);
        dataGridView.setMsg(num >0 ?  "添加成功":"添加失败");
        return dataGridView;
    }

    public DataGridView addBillsError(@RequestBody Bills bills){
        DataGridView dataGridView = new DataGridView();
        dataGridView.setCode(-1);
        dataGridView.setMsg("添加失败");
        return dataGridView;
    }


}
