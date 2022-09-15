package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.User;
import com.example.takeout.service.UserService;
import com.example.takeout.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ling
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2022-09-14 22:22:54
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}
