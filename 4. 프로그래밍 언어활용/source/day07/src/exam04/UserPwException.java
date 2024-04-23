package exam04;

public class UserPwException extends RuntimeException { // Exception -> RuntimeException

    public UserPwException(String message) {
        super(message);
    } // 컴파일러가 체크하는 예외 -> 엄격한 예외
}
