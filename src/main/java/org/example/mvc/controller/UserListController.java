package org.example.mvc.controller;

import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        request.setAttribute("users", List.of());
        // users key에 맵핑되는 value를 별도 설정하지 않았으므로, in-memory에 저장했던 UserRepository 값을 전달함 !!
        request.setAttribute("users", UserRepository.findAll());

        // user 목록 리턴
        return "/user/list";
    }
}
