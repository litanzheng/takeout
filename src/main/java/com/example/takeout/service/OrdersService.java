package com.example.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.domain.Orders;

/**
* @author ling
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-09-15 14:48:03
*/
public interface OrdersService extends IService<Orders> {

    public void submit(Orders orders);
}
