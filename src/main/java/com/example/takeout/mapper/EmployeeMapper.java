package com.example.takeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeout.domain.Employee;
import org.apache.ibatis.annotations.Mapper;


/**
* @author ling
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2022-09-09 16:58:29
* @Entity generator.domain.Employee
*/


public interface EmployeeMapper extends BaseMapper<Employee> {


}
