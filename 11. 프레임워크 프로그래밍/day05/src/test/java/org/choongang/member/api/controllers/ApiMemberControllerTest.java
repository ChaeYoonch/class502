package org.choongang.member.api.controllers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class ApiMemberControllerTest {

    private MockMvc mockMvc;

    private ApiMemberController controller;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); // 너무 많이 넣으면 느려지므로 1개만 넣음
    }

    @Test
    void test1() throws Exception {
        mockMvc.perform(post("/api/member"));
    }
}