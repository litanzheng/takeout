package com.example.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.domain.Setmeal;
import com.example.takeout.dto.SetmealDto;

import java.util.List;

/**
* @author ling
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-09-13 18:41:17
*/
public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);

}
