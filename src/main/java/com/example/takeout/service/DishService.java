package com.example.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.domain.Dish;
import com.example.takeout.dto.DishDto;

/**
* @author ling
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-09-13 18:41:17
*/
public interface DishService extends IService<Dish> {

    public void saveWithFlavour(DishDto dishDto);

    //回显修改数据
    public DishDto getByidWithFlavour(Long id);

    public void updateWithFlavour(DishDto dishDto);
}
