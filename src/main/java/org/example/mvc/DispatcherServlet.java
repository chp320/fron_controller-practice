package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")        // 어떠한 형태로 들어오던지 무조건 이 로직을 타게 한다.
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping rmhm;

    @Override
    public void init() throws ServletException {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[DispatcherServlet] service started.");

        // 맵핑된 컨트롤러에 작업을 위임
        try {
            // 요청받은 url 에 맵핑된 컨트롤러를 반환
            Controller handler = rmhm.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()), request.getRequestURI()));
            String viewName = handler.handleRequest(request, response);

            // getRequestDispatcher() 는 파라미터로 전달된 리소스에 대해 forward 하는 역할
            // 즉, 요청한 url 에 맵핑된 컨트롤러(리소스) 정보를 RequestDispatcher 에 전달하기 위해 정보를 담음
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            log.error("exception occured: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }
}
