package com.rpy.controller;

import com.rpy.common.DataGridView;
import com.rpy.domain.Bills;
import com.rpy.service.BillService;
import com.rpy.service.BillsTypeService;
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
public class BillsTypeController {

    @Reference
    private BillsTypeService billsTypeService;


    /**
     * 查询所有账单类型
     */

    @RequestMapping(value = "billsType/loadAllBillsType",method = RequestMethod.GET)
    public DataGridView loadAllBills(){
        return this.billsTypeService.queryAllBillsType();
    }




}
