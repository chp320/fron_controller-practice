package org.example.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 역할 - 한글 깨짐 현상 처리를 위해 servlet 의 filter 기능을 구현 !!
 */
@WebFilter("/*")        // 요 필터는 언제 호출할껀데?? 해당 필터 호출 시점은 모든 경로(/*) 에 대해서 적용 !! 스프링 프레임워크 "전"에 동작하는 역할 수행!!
public class CharacterEncodingFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_ENCODING);
        response.setCharacterEncoding(DEFAULT_ENCODING);

        // 다음 필터(filter)로 넘겨라. request/response 를 가지고 !!
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
