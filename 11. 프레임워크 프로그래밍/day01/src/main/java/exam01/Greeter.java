package exam01;

public class Greeter { // 스프링 컨테이너가 관리할 객체 예시
    public static void hello(String name) {
        System.out.printf("%s님 안녕하세요?", name);
    }
}