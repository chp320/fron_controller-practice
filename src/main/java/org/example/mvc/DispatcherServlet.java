package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet("/")        // 어떠한 형태로 들어오던지 무조건 이 로직을 타게 한다.
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping rmhm;

    private List<ViewResolver> viewResolvers;

    @Override
    public void init() throws ServletException {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        // viewResolver 중에 하나만 등록
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started.");

        // 맵핑된 컨트롤러에 작업을 위임
        try {
            // 요청받은 url 에 맵핑된 컨트롤러를 반환
            Controller handler = rmhm.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            String viewName = handler.handleRequest(request, response);

            // todo - HandlerMapping 이 리턴한 viewName 이 redirect/forward 인 경우 처리를 하기 위한 viewResolver 기능 추가 !!
            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolver(viewName);        // viewName 에 해당하는 view 를 리턴
                view.render(new HashMap<>(), request, response);      // 선택된 view에 맞는 render() 를 호출
            }

        } catch (Exception e) {
            log.error("exception occured: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
