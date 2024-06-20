package org.choongang.global.validators;

public interface RequiredValidator { // 인터페이스 왜 추가? 필수 항목 값이 있는지 체크하는 역할
    default void checkRequired(String str, RuntimeException e) { // default = 완전히 구현된 형태의 인스턴스 메서드
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    // 참 ture 인지 체크
    default void checkTrue(boolean checked, RuntimeException e) {
        if (!checked) {
            throw e;
        }
    }
}
