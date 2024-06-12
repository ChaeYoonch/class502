package filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

    public CommonRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);
        // 얘 제거하면 안 됨!! -> super 즉, 기본생성자만 추가되므로 | 상위클래스에 갈 수 있도록 정의하는 것!
        // 요청 전 공통 처리 부분
        System.out.println("요청 전 공통 처리 코드 ...");
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name); // super.getParameter : 상위 기능 -> 이미 값을 가져옴

        value = value == null ? value : "★" + value + "♥";

        return value; // -> 커스텀 가능!
    }
}
