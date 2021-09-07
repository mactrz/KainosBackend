package com.kainos.ea.backend.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private Environment env;

    @Autowired
    public AuthInterceptor(Environment env) {
        this.env = env;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String providedKey = request.getParameter("apikey");
        if (providedKey == null) {
            response.sendError(401, "No API Key provided");
            return false;
        }
        else if (!providedKey.equals(env.getProperty("backend.apikey"))) {
            response.sendError(401, "Provided API Key is invalid");
            return false;
        }
        return true;
    }
}
