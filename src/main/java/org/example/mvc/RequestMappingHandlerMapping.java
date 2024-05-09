package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

/**
 * 역할
 */
public class RequestMappingHandlerMapping {
    // key는 url path, value는 컨트롤러명 .. -> 즉, 요청된 url path에 따라 위임할 컨트롤러를 정의하는 역할
    // ex) [key] /users [value] UserController --> /users 로 요청이 오면 UserController 로 전달한다.
    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());    // 어떠한 경로도 설정해주지 않으면, HomeController 를 실행
    }

    /**
     * urlPath 와 일치하는 Controller 를 리턴하는 메서드
     * @param uriPath
     * @return
     */
    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }
}
