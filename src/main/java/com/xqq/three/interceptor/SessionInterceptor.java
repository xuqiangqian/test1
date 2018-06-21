package com.xqq.three.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/19 19:12
 * @Description:
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆不做拦截
        if("/user/login".equals(request.getRequestURI()) || "/user/login_view".equals(request.getRequestURI())){
            return  true;
        }
    //验证session是否存在
        Object obj=request.getSession().getAttribute("_session_user");
        if(obj == null){
            response.sendRedirect("/user/login_view");
            return  false;
        }

        return false;
    }
}
