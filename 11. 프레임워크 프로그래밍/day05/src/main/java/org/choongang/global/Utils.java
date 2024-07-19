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
    private final HttpServletRequest request; // 요청 브라우저 언어 -> 다국어 설정 등 언어 변경이 가능하도록 브라우저 설정 가져올 수 있게 -> Locale 설정

    public Map<String, List<String>> getErrorMessage(Errors errors) {
        // 1. FieldErrors 처리 : 필드별 에러 처리 O -> 배열 형태로 작성 => 이 안에서 작성하기에는 길고 아래 GlobalErrors 처리 에서도 쓰므로 아래 함수 형태로 빼서 작성함
        Map<String, List<String>> messages = errors.getFieldErrors()
                                                    .stream()
                                                    .collect(Collectors.toMap(FieldError::getField, e -> getCodeMessages(e.getCodes())));
                                                    // getCodes : validations.properties 의 NotBlank.~ 부분을 의미함
        // 2. GlobalErrors 처리
        List<String> gMessages = errors.getGlobalErrors()
                                        .stream()
                                        .flatMap(e -> getCodeMessages(e.getCodes()).stream()).toList();

        if (!gMessages.isEmpty()) { // gMessages 가 있을 때만 global 나옴
            messages.put("global", gMessages);
        }

        return messages;
    }

    // 여기에 함수로 작성 | 메세지 -> validations.properties 에서 가져옴 => 여러 개가 있으므로 <String> 으로 가져옴 | MessageConfig 의 MessageSource 부분을 이용함
    public List<String> getCodeMessages(String[] codes) { // validations.properties 의 왼쪽의 코드가 아닌 오른쪽의 값을 가져옴
        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource; // 에러 코드 -> 메세지 변경
        ms.setUseCodeAsDefaultMessage(false); // 따로 코드 등록 X -> 코드에 해당하는 게 없는데 조회하면 예외 발생 => 등록되지 않은 메세지는 아래 try ~ catch 로 들어감 | 확인할 때만 false 사용
        // MessageConfig 의 ms.setUseCodeAsDefaultMessage(true); // 메세지 코드가 값이 없으면 코드 그 자체로 메세지 대체하므로 작성해 놓음

        List<String> messages = Arrays.stream(codes) // message 를 가져와 바꿔줌
                                        .map(c -> { // c = codes 를 약자로 사용한 것
                                            try {
                                               return ms.getMessage(c, null, request.getLocale()); // args: Object 배열로 되어 있음 | commons.properties 의 순서대로 들어감 = {} 부분 치환 | Locale = 지역화 정보
                                            } catch (Exception e) { // 여기로 들어온 예외는 빈 값 으로 나옴
                                                return "";
                                            }
                                        }) // 지역화 -> 언어 변동 기능
                                        .filter(s -> s != null && !s.isBlank())
                                        .toList();

        ms.setUseCodeAsDefaultMessage(true); // MessageConfig 에서 가져온 식이 싱글톤 이므로 1번 설정되면 바뀌지 않기에 위에서 쓰고 나서 오류가 발생함 그러므로 원래 코드가 나올 수 있도록 다시 변경함 | 즉, 쓸 때만 바꾸고 그 외는 원래대로 나오도록 함
        return messages;
    }
}