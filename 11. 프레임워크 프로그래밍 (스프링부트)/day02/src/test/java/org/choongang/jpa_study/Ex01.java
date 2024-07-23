package org.choongang.jpa_study;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test") // application-test.yml 로 실행
public class Ex01 {

}