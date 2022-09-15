package com.example.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.takeout.domain.Employee;

import javax.servlet.http.HttpServletRequest;

/**
* @author ling
* @description 针对表【employee(员工信息)】的数据库操作Service
* @createDate 2022-09-09 12:10:05
*/
public interface EmployeeService extends IService<Employee> {


    Employee employeeLogin(String username,String password,HttpServletRequest request);

}
