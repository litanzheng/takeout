package com.example.takeout.controller;


import com.example.takeout.common.R;
import com.example.takeout.domain.Orders;
import com.example.takeout.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private OrdersService ordersService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单数据 {}",orders);
        ordersService.submit(orders);
        return R.success("下单成功");
    }
}
