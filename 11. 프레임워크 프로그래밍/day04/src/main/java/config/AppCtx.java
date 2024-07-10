package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcRepositories
public class AppCtx {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        /* DB 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
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

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    } // 객체 조립하여 만듦

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }
}