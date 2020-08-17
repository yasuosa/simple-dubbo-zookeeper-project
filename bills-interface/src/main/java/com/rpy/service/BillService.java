package com.rpy.service;

import com.rpy.common.DataGridView;
import com.rpy.domain.Bills;
import com.rpy.vo.BillsVo;

import java.util.List;

/**
 * @program: bills
 * @description:
 * @author: 任鹏宇
 * @create: 2020-08-17 20:16
 **/
public interface BillService {


    /**
     * 根据类型和时间查询账单
     */
    DataGridView queryAllBills(BillsVo billsVo);

    /**
     * 添加账单
     */
    int addBills(Bills bills);

}
