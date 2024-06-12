package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class BoardFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { // 자료형이 상위의 인터페이스로 되어있음
        System.out.println("BoardFilter - 요청 전"); // 원래 : doFilter()! -> 요청 전 필터

        chain.doFilter(request, response); // 다음 필터 또는 서블릿의 처리 메서드 실행

        System.out.println("BoardFilter - 응답 후");// 응답 후 필터
    }
}
