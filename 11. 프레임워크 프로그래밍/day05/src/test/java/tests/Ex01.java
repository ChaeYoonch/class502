package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.choongang.config.MvcConfig;
import org.choongang.exam.PostData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

        String itemsBody = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        System.out.println(itemsBody);
    }
}