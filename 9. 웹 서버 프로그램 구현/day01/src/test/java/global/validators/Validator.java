package global.validators;

public interface Validator<T> { // <T> : 지네릭 클래스 -> 다양한 형태 정의
    void check(T form);
}
