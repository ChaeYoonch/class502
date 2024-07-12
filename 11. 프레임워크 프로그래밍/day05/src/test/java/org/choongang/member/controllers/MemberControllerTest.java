package org.choongang.member.controllers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class MemberControllerTest {

    @Autowired
    private WebApplicationContext ctx; // 스프링 컨테이너 가져옴

    private MockMvc mockMvc;

    @BeforeEach
    void init() { // 초기화 작업
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); // WebApplicationContext 로 설정한 이유 ? 다형성
    }

    @Test
    void test1() throws Exception {
        mockMvc.perform(post("/member/join")
                        .header("appKey", "1234") // 요청 헤더
                        .contentType("application/json")) // 요청쪽 Content-Type
                .andDo(print());
    }
}