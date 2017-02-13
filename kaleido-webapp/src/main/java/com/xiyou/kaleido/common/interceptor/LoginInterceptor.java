package com.xiyou.kaleido.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiyou.kaleido.common.http.KaleidoStatus;
import com.xiyou.kaleido.common.model.ResponseModel;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by chad.ding on 2017/2/13.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        UUID TOKEN = (UUID)session.getAttribute("TOKEN");

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("TOKEN".equals(cookie.getName()) && cookie.getValue().equals(TOKEN.toString())){
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        ResponseModel model = new ResponseModel(KaleidoStatus.SESSION_TIMEOUT, "登录超时");
        response.getWriter().write(JSONObject.toJSONString(model));

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("hello");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}