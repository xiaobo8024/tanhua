package com.tanhua.server.interceptor;

import com.tanhua.domain.db.User;
import com.tanhua.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
/**
 * token统一处理
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    /**
     * 判断是否是token是否放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("token统一处理.................");
        String token = request.getHeader("Authorization");
        User user = userService.getUser(token);
        if(user==null){
            //响应404给前端
            response.setStatus(401);
            return false;
        }
        //将user存入到线程中
        UserHolder.setUser(user);
        return true;
    }
}