package org.spoto.inceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//
        Object logined = request.getSession().getAttribute("logined");
        if (logined!=null){
            return true;
        }else {
            response.sendRedirect("login.html");
            return false;
        }

    }
}
