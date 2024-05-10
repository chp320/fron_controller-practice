package org.example.mvc.view;

import static org.example.mvc.view.RedirectView.DEFAULT_REDIRECT_PREFIX;

public class JspViewResolver implements ViewResolver {
    @Override
    public View resolver(String viewName) {

        // viewName 이 "redirect:" 로 시작하는 경우엔 redirect 방식이기 때문에 RedirectView 를 리턴함!
        if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
            return new RedirectView(viewName);
        }
        // 그렇지 않은 경우는 jsp 뷰로 판단해서 JspView 리턴 !!
        return new JspView(viewName + ".jsp");
    }
}
