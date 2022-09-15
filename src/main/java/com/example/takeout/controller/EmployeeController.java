package com.example.takeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.takeout.common.R;
import com.example.takeout.domain.Employee;
import com.example.takeout.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static com.example.takeout.constant.EmployeeConstant.EMPLOYEE_LOGIN_STATUS;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/login")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest request){
        if (employee==null){
            return R.error("参数传输错误");
        }
        String username = employee.getUsername();
        String password = employee.getPassword();
        if (StringUtils.isAnyBlank(username,password)){
            return R.error("用户名或密码为空");
        }
        Employee checkeEmp = employeeService.employeeLogin(employee.getUsername(), employee.getPassword(), request);
        if (checkeEmp==null){
//            用户名，密码，用户状态错误
            return R.error("用户名或密码错误");
        }
        return R.success(checkeEmp);
    }

    @RequestMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute(EMPLOYEE_LOGIN_STATUS);
        return R.success("退出成功");
    }

    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){

        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
        Employee creater = (Employee)request.getSession().getAttribute(EMPLOYEE_LOGIN_STATUS);

        employee.setCreateUser(creater.getId());
        employee.setUpdateUser(creater.getId());
        employeeService.save(employee);

        return R.success("添加员工成功");
    }

    /*
    分页信息展示
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        log.info("page= {},pageSize= {},name= {}",page,pageSize,name);
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
//        queryWrapper.like(StringUtils.isAnyEmpty(name),Employee::getName,name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info(employee.toString());
        Employee employee1 = (Employee) request.getSession().getAttribute(EMPLOYEE_LOGIN_STATUS);
        employee.setUpdateUser(employee1.getId());
//        employee.setUpdateTime(LocalDateTime.now());
        employeeService.updateById(employee);
        return R.success("员工状态修改成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getByID(@PathVariable Long id){
        log.info("根据id查询用户信息");
        Employee employee = employeeService.getById(id);
        if (employee!=null){
            return R.success(employee);
        }
        return R.error("没有查询到运功信息");
    }
}
