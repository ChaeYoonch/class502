package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory;
    // 처음부터 초기화
    static {
        try {
            Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-config.xml");

            factory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // SqlSession 설정
    public static SqlSession getSession(boolean autoCommit) {
        String mode = System.getenv("mode"); // 환경변수 설정
        if (mode != null && mode.equals("test")) autoCommit = false; // mode 가 null 이 아니고 "test" 에서는 autoCommit 안함
        return factory.openSession(autoCommit); // 회원가입 기능에서 사용
    }

    public static SqlSession getSession() {
        return getSession(true); // 회원가입 기능 & 로그인 기능 에서 사용
    }
}