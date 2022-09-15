package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.SetmealDish;
import com.example.takeout.service.SetmealDishService;
import com.example.takeout.mapper.SetmealDishMapper;
import org.springframework.stereotype.Service;

/**
* @author ling
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Service实现
* @createDate 2022-09-14 16:26:31
*/
@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish>
implements SetmealDishService{

}
