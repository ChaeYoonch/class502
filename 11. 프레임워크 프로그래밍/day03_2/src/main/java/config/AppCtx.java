package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        /* DB 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /* DB 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setTestWhileIdle(true); // 유휴 객체 유효성 체크
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000); // 10초에 1번씩 연결 상태 체크
        ds.setMinEvictableIdleTimeMillis(1000 * 60); // 유휴 객체 생존 시간 1분 -> 이후에는 소멸하고 다시 만들어짐
        /* 커넥션 풀 설정 E */

        return ds;
    }
}