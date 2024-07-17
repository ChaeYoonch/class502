package org.choongang.member.api.controllers;

import org.choongang.config.MvcConfig;
import org.choongang.member.controllers.RequestJoin;
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
public class ApiMemberControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ApiMemberController controller;

    // @Autowired
    // private WebApplicationContext ctx;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); // 너무 많이 넣으면 느려지므로 1개만 넣음
        // mockMvc = MockMvcBuilders.standaloneSetup(ctx).build();
    }

    @Test
    void test1() throws Exception {
        // Content-Type : application/json

        RequestJoin form = new RequestJoin();
        form.setEmail("user99@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword("12345678");
        form.setUserName("사용자99");
        form.setAgree(true);

        // Content-Type : application/x-www-form-urlencoded
        // 이름=값&이름=값 ...
        /* mockMvc.perform(post("/api/member")
                .param("email", "user99@test.org")
                .param("password", "12345678")
                .param("confirmPassword", "12345678")
                .param("userName", "사용자99"))
                .andDo(print()); */
    }
}