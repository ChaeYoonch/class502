package org.choongang.global;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

@Component
public class Utils { // 편의 기능 모음
    public Map<String, List<String>> getErrorMessage(Errors errors) {
        // 1. FieldErrors 처리
        Map<String, List<String>> messages = errors.getFieldErrors()
    }
}