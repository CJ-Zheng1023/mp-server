package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户模块
 *
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 当token失效时转发到该路由
     * @return
     */
    @GetMapping("/nologin")
    public Map<String, String> noLogin(){
        Map<String, String> result = new HashMap<String, String>();
        result.put("error", Constant.NO_LOGIN);
        return result;
    }
    /**
     * 注册
     *
     * @return
     */
    @PostMapping("/add")
    public Map<String, String> addUser(@RequestBody Map postMap) {
        String username = (String) postMap.get("username");
        String password = (String) postMap.get("password");
        return userService.addUser(username, password);
    }

    /**
     * 登录
     *
     * @param
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map postMap) {
        String username = (String) postMap.get("username");
        String password = (String) postMap.get("password");
        Map<String, Object> map = new HashMap<String, Object>();
        map = userService.login(username, password);
        return map;
    }

    /**
     * 退出
     *
     * @param
     * @return
     */
    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        String userId = (String) request.getAttribute(Constant.USER_ID);
        return userService.logout(userId);
    }


}
