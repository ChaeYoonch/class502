package org.choongang.global.validators;

public interface EmailValidator { // 필요한 때만 추가 | 참, 거짓 사용
    default boolean checkEmail(String email) {
        // 계정명@도메인.com/co.kr ...
        String pattern = "[^@]+@[^.]+\\.[a-z]+"; // ^@ = @ 아닌 것 1개 이상

        return email.matches(pattern);
    }
}
