package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;
import org.example.mvc.controller.UserListController;

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
        mappings.put("/users", new UserListController());    // 컨트롤러가 추가될 때마다 URI, 컨트롤러명 정보를 등록해야 함 !!
        // 그런데 동일한 URI에 GET/POST method에 따라 컨트롤러를 다르게 호출하고 싶은 경우에
        // mappings.put("/users", new UserCreateController()); 와 같이 등록이 가능할까?? -> 안된다. key인 "/users" 가 이미 등록되어 있기 때문에 불가하다!
        // 그러면 어떻게 해야하지?
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
