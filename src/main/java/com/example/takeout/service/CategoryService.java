package com.example.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.domain.Category;


/**
* @author ling
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-09-13 14:58:22
*/
public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
