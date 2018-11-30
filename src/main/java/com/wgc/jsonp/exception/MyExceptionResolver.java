package com.wgc.jsonp.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常
/*全局的，启动时就会添加到spring容器中*/
@Component
public class MyExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof DBException) {
            //返回错误的页面
            return new ModelAndView("error");
        } else if (e instanceof DataVlidateException) {
            //返回原本的页面
            return new ModelAndView("index");
        } else if (e instanceof RuntimeException) {
            //未知的异常
            //返回到一个指定的页面
            return new ModelAndView("error");
        }
        return new ModelAndView("error");
    }
}
