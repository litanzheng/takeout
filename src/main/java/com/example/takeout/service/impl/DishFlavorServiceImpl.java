package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.DishFlavor;
import com.example.takeout.service.DishFlavorService;
import com.example.takeout.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author ling
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-09-13 21:25:10
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
implements DishFlavorService {

}
