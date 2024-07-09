package config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class DBConnectionTest {

    @Autowired // 의존성 주입 받고 바로 쓸 수 있음
    private DataSource dataSource;

    @Test
    void test1() throws Exception {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}