package exam04;

public class UserIdException extends RuntimeException { // Exception -> RuntimeException

    public UserIdException(String message) {
        super(message);
    }
} // 예외 클래스 생성 & 생성자 위임 처리
