package org.choongang.global;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Utils { // 편의 기능 모음

    private final MessageSource messageSource; // 의존성 추가
    private final HttpServletRequest request;

    public Map<String, List<String>> getErrorMessage(Errors errors) {
        // 1. FieldErrors 처리
        Map<String, List<String>> messages = errors.getFieldErrors()
                                                    .stream()
                                                    .collect(Collectors.toMap(FieldError::getField, e -> e.getCodes()))
    }

    public List<String > getCodeMessages(String[] codes) {

    }
}