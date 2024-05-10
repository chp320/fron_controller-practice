package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        // 전달된 핸들러가 Controller 인터페이스를 구현한 구현체라면 지원을 해주겠다 !!
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // handler 를 Controller 타입캐스팅 함!! 해당 handler 를 수행 !!
        String viewName = ((Controller) handler).handleRequest(request, response);

        return new ModelAndView(viewName);      // ModelAndView 객체로 감싸서 리턴 !
    }
}
