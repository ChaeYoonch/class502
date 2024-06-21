package exam01;

public class JoinService {
    public JoinService() {
        System.out.println("기본 생성자 호출"); // 생성자 매개변수 0개
    }

    public JoinService(String arg1, int arg2) {
        System.out.printf("매개변수가 있는 생성자 호출:%s, %d%n", arg1, arg2); // 생성자 매개변수 2개로 고정
    }

    public JoinService(String arg1, int arg2, long arg3) {
        System.out.printf("매개변수가 있는 생성자 호출:%s, %d, %d%n", arg1, arg2, arg3); // 생성자 매개변수 3개로 고정
    }
}