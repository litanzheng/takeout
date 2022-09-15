package com.example.takeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.takeout.common.R;
import com.example.takeout.domain.User;
import com.example.takeout.service.UserService;
import com.example.takeout.utils.SMSUtils;
import com.example.takeout.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        String phone = user.getPhone();
        if (phone != null) {
            String code = ValidateCodeUtils.generateValidateCode4String(4);
            log.info("code={}", code);
//        SMSUtils.sendMessage("瑞吉外卖",phone,code);
            session.setAttribute(phone, code);
            return R.success("手机验证码短信发送成功");
        }
        return R.error("短信发送失败");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info("map {}", map);
        String phone = map.get("phone").toString();
        map.put("code","1234");
        String code = map.get("code").toString();
        String codeSession = "1234";
        session.setAttribute("code", codeSession);
        Object codeInSession = session.getAttribute("code");
        if (codeInSession != null && codeInSession.equals(code)) {
            //判断用户是否为新用户
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                user = new User();
                user.setPhone(phone);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            return R.success(user);
        }
        return R.error("登录失败");
    }
}
