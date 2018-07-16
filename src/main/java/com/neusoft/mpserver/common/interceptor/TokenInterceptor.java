package com.neusoft.mpserver.common.interceptor;

import com.google.gson.Gson;
import com.neusoft.mpserver.dao.TokenRepository;
import com.neusoft.mpserver.domain.Constant;
import com.neusoft.mpserver.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * token验证拦截器
 * @name fandp
 * @email fandp@neusoft.om
 */
public class TokenInterceptor implements HandlerInterceptor{
    @Autowired
    private TokenRepository tokenRepository;
    @Value("${system.params.env}")
    private String env;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(env.equals("development")){
            return true;
        }
        String token=request.getHeader("token");
      //  String token = request.getParameter("token");
        Token tokenDomain=tokenRepository.findByTokenId(token);
        if (tokenDomain == null) {
            Map<String,String> map=new HashMap<String, String>();
            map.put("error",Constant.NO_LOGIN);
            Gson gson = new Gson();
            String resultStr = gson.toJson(map);
            response.getWriter().write(resultStr);
            return false;
        } else {
            request.setAttribute(Constant.USER_ID, tokenDomain.getUserId());
            //token没有过期放行
            return true;
        }
    }
}
