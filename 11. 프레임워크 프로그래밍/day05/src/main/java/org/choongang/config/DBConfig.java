package org.choongang.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource(); // ds 로 아래 모든 값 연결하였기에 return ds; 임!

        /* DB 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /* DB 연결 설정 E */

        /* 커넥션 풀 설정 S : 연결 유효한 지 확인하는 것 */
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(1000 * 60); // 유효 객체가 살아있는 시간 | 기본값 = 1분
        ds.setTimeBetweenEvictionRunsMillis(1000 * 5); // 기본값 : 5초에 1번씩 확인
        /* 커넥션 풀 설정 E */

        return ds;
    }
}