package org.example.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RedirectView implements View {

    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String viewName;

    public RedirectView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 지금 viewName 은 "redirect:/user" 와 같은 형태로 전달되었기 때문에 불필요한 'redirect:' 문자는 substring() 을 통해 제거해 준다.
        // redirect 는 sendRedirect() 를 통해서 수행됨 !!

        // redirect 방식
        response.sendRedirect(viewName.substring((DEFAULT_REDIRECT_PREFIX).length()));
    }
}
