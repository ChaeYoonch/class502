<%@ page contentType="text/html; charset=UTF-8" %>
<% // 스트립틀릿
    // _jspService() 지역 내부
    int num1 = 100;
    int num2 = 200;
    int result = num1 + num2;
    // out.write("result=" + (num1+num2));
    out.write("result=" + result);

    out.write("<br>이름 : " + name);
    print(); // 함수가 선언문 태그에 있어도 호출 O (= 함수가 클래스 바로 아래 있기에 실제 위치 상으로는 <% %> 보다 위에 정의되어 있음)
// System.out.println(request);
%>
<br>
<%-- JSP 주석 (번역 X) ... --%>
<%--
<%=num1%> + <%=num2%> = <%=result%>
--%>

<%! // 선언문
    // 클래스명 바로 아래쪽 -> 멤버 변수 => 인스턴스 자원이다!! => 다른 함수 내에서도 사용 가능!
    String name = "이이름";
    void print() {
        System.out.println(name);
    }
%>