package global.validators;

public interface RequiredValidator {
    default void checkRequired(String field, RuntimeException e) {// default 메서드
        if ( field == null || field.isBlank()) { // field 가 null 이거나 공백인 경우
            throw e;
        }
    }
}
