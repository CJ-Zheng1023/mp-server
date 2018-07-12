package com.neusoft.mpserver.controller;

import com.neusoft.mpserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 *   用户模块
 * @name fandp
 * @email fandp@neusoft.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public  String addUser(String username,String password){
          return userService.addUser(username,password);
    }

    @PostMapping("/login")
    public Map<String, Object> login(String username, String password, Model model){
        Map<String, Object> map = new HashMap<String, Object>();
        map=userService.login(username,password);
        return map;
    }

}
