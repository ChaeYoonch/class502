package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@RequiredArgsConstructor
public class ThymeleafConfig {
    private final WebApplicationContext applicationContext;
}