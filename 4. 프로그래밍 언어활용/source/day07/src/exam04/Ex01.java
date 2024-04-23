package exam04;

public class Ex01 {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        try {
            service.login("user02", "123456"); // 내부에서 try ~ catch 구문으로 나온 결과
        } catch (Exception e) { // UserIdException | UserPwException e -> Exception e : 다형성
           System.out.println(e.getMessage()); // 호출한 쪽에서 예외 처리 미뤄서 .. 예외 전가
        }
    }
}
