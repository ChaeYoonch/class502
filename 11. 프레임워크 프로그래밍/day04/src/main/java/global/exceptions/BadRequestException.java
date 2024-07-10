package global.exceptions;

public class BadRequestException extends CommonException {
    public BadRequestException(String message) { // BadRequestException = 기본 생성자
        super(message);
    }
}