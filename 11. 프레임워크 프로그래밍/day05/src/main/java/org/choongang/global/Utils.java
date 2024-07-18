package org.choongang.global;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
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
                                                    .collect(Collectors.toMap(FieldError::getField, e -> getCodeMessages(e.getCodes())));

        // 2. GlobalErrors 처리
        List<String> gMessages = errors.getGlobalErrors()
                                        .stream()
                                        .flatMap(e -> getCodeMessages(e.getCodes()).stream()).toList();

        if (!gMessages.isEmpty()) { // gMessages 가 있을 때만 global 나옴
            messages.put("global", gMessages);
        }

        return messages;
    }

    public List<String > getCodeMessages(String[] codes) {
        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource; // 에러 코드 -> 메세지 변경
        ms.setUseCodeAsDefaultMessage(false); // 확인할 때만 false 사용

        List<String> messages = Arrays.stream(codes) // message 를 가져와 바꿔줌
                                        .map(c -> messageSource.getMessage(c, null, request.getLocale())) // 지역화 -> 언어 변동 기능
                                        .filter(s -> s != null && !s.isBlank())
                                        .toList();

        ms.setUseCodeAsDefaultMessage(true); // 위의 식이 싱글톤 이므로 쓰고 나서 원래 코드가 나올 수 있도록 다시 변경
        return messages;
    }
}