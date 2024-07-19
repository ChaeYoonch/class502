package org.choongang.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig { // MvcConfig 에 통합

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("messages.commons", "messages.validations", "messages.errors"); // classpath 기준으로 작성 | resources > messages > errors.properties, validations.properties
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true); // 메세지 코드가 값이 없으면 코드 그 자체로 메세지 대체함 | 등록이 되어있지 않으면 메세지 코드 그 자체가 나오도록 연동됨
        return ms;
    } // 싱글톤 패턴 -> 1번 만들어진 상태로 유지됨
}