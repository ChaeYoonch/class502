package org.choongang.jpa_study;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 하나의 묶음으로 관리 -> 트랜잭션 처리 필수!
@TestPropertySource(properties = "spring.profiles.active=test") // test 로하지 않으면 oracle db 사용 함
public class Ex02 {

}