package org.choongang.global.validators;

public interface Validator<T> { // DTO -> 즉, 데이터 검증
    void check(T form);
}