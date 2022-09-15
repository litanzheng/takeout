package com.example.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeout.domain.Employee;
import com.example.takeout.mapper.EmployeeMapper;
import com.example.takeout.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.example.takeout.constant.EmployeeConstant.EMPLOYEE_LOGIN_STATUS;

/**
* @author ling
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-09-09 12:10:05
*/
@Service
//@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee employeeLogin(String username, String password, HttpServletRequest request) {

        if (StringUtils.isAnyBlank(username,password)){
            return null;
        }
        //对密码进行加密
        String encryptPassword = DigestUtils.md5DigestAsHex(username.getBytes());

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Employee employee = employeeMapper.selectOne(queryWrapper);
        if (employee==null){
            return null;
        }
        //校验密码是否一致
        if (!employee.getPassword().equals(encryptPassword)){
            return null;
        }
        if (employee.getStatus()==0){
            return null;
        }
        request.getSession().setAttribute(EMPLOYEE_LOGIN_STATUS,employee);

        return employee;
    }
}
