package org.choongang.member.mappers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig // 얘가 중요!!
@ContextConfiguration(classes = MvcConfig.class)
public class MapperTest {

    @Autowired // 의존성 주입
    private MemberMapper mapper;

    @Test
    void test1() {
        long total = mapper.getTotal();
        System.out.println(total);
    }
}