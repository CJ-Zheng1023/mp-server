package com.neusoft.mpserver.common.interceptor;

import com.google.gson.Gson;
import com.neusoft.mpserver.dao.TokenRepository;
import com.neusoft.mpserver.domain.Constant;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String getToken = request.getParameter("token");
        if (tokenRepository.findByTokenId(getToken) == null) {
            Map<String,String> map=new HashMap<>();
            map.put("error",Constant.NO_LOGIN);
            Gson gson = new Gson();
            String resultStr = gson.toJson(map);
            response.getWriter().write(resultStr);
            return false;
        } else {
            //token没有过期放行
            return true;
        }
    }
}
