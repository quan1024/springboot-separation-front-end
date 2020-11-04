package com.quan.config;

import com.quan.controller.InterfaceController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if (loginUser == null) {
//            request.setAttribute("quitInfo", "没有权限，请先登录");
//            request.getRequestDispatcher("/").forward(request, response);
////            response.sendRedirect(request.getContextPath()+"/");
//            return false;
//        } else {
//            return true;
//        }
        //System.out.println(request.getQueryString());
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getValue());
        }
        if (cookies != null) {
            return true;
        }
        return false;*/
        Cookie[] cookies=request.getCookies();
        System.out.println("浏览器中的Cookie:");
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getValue());
            }
        }
        System.out.println("内存中的Session"+InterfaceController.sessionMap);
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(InterfaceController.sessionMap.get(cookie.getValue())!=null){
                    System.out.println("有匹配的SessionID");
                    return true;
                }
            }
        }
        response.sendRedirect(request.getContextPath()+"/api/loginFail");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
