package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { // 최초 1번 실행
        System.out.println("init()");
        String key1 = filterConfig.getInitParameter("key1");
        String key2 = filterConfig.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);
    }

    @Override
    public void destroy() { // 종료 시 실행
        System.out.println("destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // System.out.println("CommonFilter - 요청 전"); -> 코드를 직접 작성하는 것은 지양!!

        chain.doFilter(new CommonRequestWrapper(request), response); // chain.doFilter(request, response);
            // 생성자 안에 정의 -> CommonRequestWrapper(request) => CommonRequestWrapper 의 요청 전 공통 처리 코드
        // System.out.println("CommonFilter - 응답 후");
    }
}
