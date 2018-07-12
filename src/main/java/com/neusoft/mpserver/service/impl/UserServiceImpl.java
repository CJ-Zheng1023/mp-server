package com.neusoft.mpserver.service.impl;

import com.neusoft.mpserver.common.util.IDGenerator;
import com.neusoft.mpserver.dao.TokenRepository;
import com.neusoft.mpserver.dao.UserRepository;
import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.domain.Mp_Token;
import com.neusoft.mpserver.domain.Mp_User;
import com.neusoft.mpserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户模块service层实现
 * @name fandp
 * @email fandp@neusoft.com
 */
@Service
public class UserServiceImpl implements UserService {
    private Constant constant;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    /**
     * 注册逻辑
     * @param username
     * @param password
     * @return
     */
    @Override
    public String addUser(String username,String password) {
      System.out.println(userRepository.findByUsername(username).isEmpty());
      if(userRepository.findByUsername(username).isEmpty()){
          Mp_User user=new Mp_User();
          user.setUsername(username);
          user.setPassword(password);
          String userid= IDGenerator.generate();
          user.setId(userid);
          Date day=new Date();
          SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          user.setCreateTime(df.format(day));
          userRepository.save(user);
          return Constant.getSuccessRegister();
       }else{
          return Constant.getFailRegister();
      }

    }

    /**
     * 登录逻辑
     * @param username
     * @param password
     * @return
     */
    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(userRepository.findByUsername(username).isEmpty()){
            map.put("code", Constant.getNouserLogin());
            return map;
        }else if(userRepository.findByUsernameAndPassword(username, password)== null){
            map.put("code",Constant.getFailpassLogin());
            return map;
        }else{
            //登录成功
            map.put("code",Constant.getSuccessLogin());
            Mp_User user=userRepository.findByUsernameAndPassword(username, password);
            Mp_User loginUser=new Mp_User();
            loginUser.setCreateTime(user.getCreateTime());
            loginUser.setId(user.getId());
            loginUser.setUsername(user.getUsername());
            map.put("user",loginUser);
            //token
            Mp_Token token=new Mp_Token();
            String tokenId=IDGenerator.generate();
            Date day=new Date();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String lastTime=df.format(day);
            token.setId(tokenId);
            token.setLast_time(lastTime);
            token.setUser_id(user.getId());
            tokenRepository.save(token);
            map.put("token",token);
            return map;
        }
    }
}
