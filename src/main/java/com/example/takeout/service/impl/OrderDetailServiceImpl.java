package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.OrderDetail;
import com.example.takeout.service.OrderDetailService;
import com.example.takeout.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author ling
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-09-15 14:48:03
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
implements OrderDetailService{

}
