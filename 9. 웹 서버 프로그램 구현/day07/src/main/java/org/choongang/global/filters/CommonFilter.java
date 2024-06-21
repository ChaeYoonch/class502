package org.choongang.global.filters;

import jakarta.servlet.*;
        import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*") // 모든 요청에 유입되는 필터로 설정 = /*
public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(new CommonRequestWrapper(request), response); // request 를 wrapper 로 정의할 것
    }
}