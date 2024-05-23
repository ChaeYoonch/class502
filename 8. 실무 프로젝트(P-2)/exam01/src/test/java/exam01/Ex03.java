package exam01;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex03 {

    /* DB 연결 URL , 계정 */
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "STUDY";
    private String password = "oracle";

    @BeforeAll
    static void init() {
        try {
            // 오라클 드라이버 동적 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test1() {
        String sql = "CALL REGISTER_MEMBER(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, "USER99");
            cstmt.setString(2, "123456");
            cstmt.setString(3, "사용자99");
            cstmt.setString(4,"010-0000-0000");

            int cnt = cstmt.executeUpdate();
            System.out.println(cnt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        // 커넥션 풀 제공
        DataSource ds = new DataSource();
        /* DB 연결 설정 S */
        ds.setDriverClassName("oracle.jdnc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("STUDY");
        ds.setPassword("oracle");
        /* DB 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2); // 로드 초기에 생성할 연결 객체 수 | 기본값 = 10
        ds.setMaxActive(10); // 최대 생성할 연결 객체 수 | 기본값 = 100
        ds.setTestWhileIdle(true); // 연결 객체가 유휴 상태일 때 연결 상태 체크 -> 주기적으로 쿼리 확인
        ds.setTimeBetweenEvictionRunsMillis(5 * 1000); // 1000분의 1초 단위로 설정 -> 5초에 1번씩 연결 상태 체크
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 유휴 객체를 일정 시간이 되면 내보내고 다시 생성 | 기본값 = 1분
        // -> 유휴 상태 객체를 30초 이후에 소멸 후 새로 생성
        /* 커넥션 풀 설정 E */

        /* Connection 객체 생성 */
        try (Connection conn = ds.getConnection()) {
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3() {
        /* 연결 설정 S */
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        config.setUsername("STUDY");
        config.setPassword("oracle");
        /* 연결 설정 E */

        /* 커넥션 풀 설정 S */
        config.setMinimumIdle(2); // 최소 2개 이상
        config.setMaximumPoolSize(10); // 최대 10개 이하
        /* 커넥션 풀 설정 E */

        /* DataSource 객체 생성 */
        HikariDataSource ds = new HikariDataSource(config);

        /* Connection 객체 생성 */
        try (Connection conn = ds.getConnection()) {
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
