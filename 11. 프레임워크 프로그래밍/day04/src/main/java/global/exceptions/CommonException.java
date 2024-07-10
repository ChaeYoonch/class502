package global.exceptions;

public class CommonException extends RuntimeException { // 공통 예외 부분
    public CommonException(String message) {
        super(message);
    }
}