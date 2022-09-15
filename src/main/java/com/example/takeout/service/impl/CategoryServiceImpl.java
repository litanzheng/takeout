package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.common.CustomException;
import com.example.takeout.domain.Category;
import com.example.takeout.domain.Dish;
import com.example.takeout.domain.Setmeal;
import com.example.takeout.service.CategoryService;
import com.example.takeout.mapper.CategoryMapper;
import com.example.takeout.service.DishService;
import com.example.takeout.service.SetmealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author ling
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2022-09-13 14:58:22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {


    @Resource
    private DishService dishService;

    @Resource
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getCategoryId, id);
        long count = dishService.count(queryWrapper);
        if (count > 1) {
            throw new CustomException("当前分类关联了菜品不能删除");
        }

        LambdaQueryWrapper<Setmeal> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(Setmeal::getCategoryId, id);
        long count2 = setmealService.count(queryWrapper2);
        if (count2>0){
            throw new CustomException("当前分类关联了套餐不能删除");
        }
        super.removeById(id);
    }
}
