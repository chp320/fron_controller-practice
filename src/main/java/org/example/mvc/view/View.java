package org.example.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * View 는 jsp뷰 일수도 있고, redirect뷰 일 수도 있기 때문에, 인터페이스를 구현하도록 함 !!
 */
public interface View {

    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
