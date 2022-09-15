package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.ShoppingCart;
import com.example.takeout.service.ShoppingCartService;
import com.example.takeout.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author ling
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-09-15 11:00:10
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
implements ShoppingCartService{

}
