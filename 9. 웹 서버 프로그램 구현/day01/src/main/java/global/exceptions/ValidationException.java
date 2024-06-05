package global.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) { // 생성자 정의
        super(message); // super() -> 얘가 기본
    }
}
