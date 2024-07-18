package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.choongang.config.MvcConfig;
import org.choongang.exam.PostData;
import org.choongang.member.controllers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class Ex01 {

    @Autowired
    private ObjectMapper om; // 수동 등록 빈 | 의존성 주입

    @Test
    void test1() {
        URI url = UriComponentsBuilder.fromUriString("https://www.naver.com")
                                       // .path("/news/{0}")
                                      .queryParam("t1", "v1")
                                      .queryParam("t2", "v2")
                                      .queryParam("t3", "한글") // ED%95%9C%EA%B8%80
                                      // .queryParam("t3", "ED%95%9C%EA%B8%80")
                                      // .queryParam("t4", "aa{1}")
                                      .fragment("hash")
                                      .encode()
                                      .build("AAAA", "BBBB");
                                      // .build(true); 쿼리 스트링 중에 encoding 된 것이 있다 의 의믜
        System.out.println(url.getQuery());
        System.out.println(url);
    }

    @Test
    void test2() {
        RestTemplate restTemplate = new RestTemplate();
        PostData data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", PostData.class);
        System.out.println(data);
    }

    @Test
    void test3() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);

        // System.out.println(body);
        // 단일 객체 변환
        PostData data = om.readValue(body, PostData.class);
        System.out.println(data);

        // 복합 데이터 객체 변환 - List, Set, Map ...
        String itemsBody = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        // System.out.println(itemsBody);
        List<PostData> items = om.readValue(itemsBody, new TypeReference<>(){}); // 추상 클래스 이므로 뒤에 {} 빈 상태로 추가해야 함
        items.forEach(System.out::println); // 요기 System.out.println(data); 값 연결함
    }

    @Test
    @DisplayName("JSON 방식으로 POST 처리 예시")
    void test4() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        RequestJoin form = new RequestJoin();
        form.setEmail("user999@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword("12345678");
        form.setUserName("사용자999");
        form.setAgree(true);

        String params = om.writeValueAsString(form); // 전송할 데이터 | throws Exception 사용해 오류 발생 X
        // System.out.println(params);

        HttpHeaders headers = new HttpHeaders(); // 헤더
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(params, headers); // 바디

        String url = "http://localhost:3000/day05/api/member";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response);
    }

    @Test
    @DisplayName("일반 양식 형식으로 전송 - Content-Type : application/x-www-form-urlencoded")
    void test5() {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); // 보낼 데이터 담는 곳
        params.add("email", "user998@test.org");
        params.add("password", "12345678");
        params.add("confirmPassword", "12345678");
        params.add("userName", "사용자998");
        params.add("agree", "true");
    }
}