package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean // 수동 등록 빈
    public ObjectMapper objectMapper() {

    }
}