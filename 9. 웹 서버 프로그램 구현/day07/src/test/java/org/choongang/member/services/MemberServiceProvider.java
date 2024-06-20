package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.tests.LoginServiceTest;
import org.choongang.member.validators.JoinValidator;

// 객체 조립기
public class MemberServiceProvider { // 싱글톤 패턴 사용
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {} // 기본 생성자 private 로 차단
    // (회원쪽 기능)
    public static MemberServiceProvider getInstance() {
        if (instance == null) { // 싱글톤 - 필요할 때 1번만 만들어 공유
            instance = new MemberServiceProvider();
        }

        return instance;
    }

    public MemberMapper memberMapper() {
        SqlSession session = DBConn.getSession();
        return session.getMapper(MemberMapper.class);
    }

    public JoinValidator joinValidator() { // 회원가입 검증 Validator
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }

    // (로그인 기능)
    public LoginService loginService() {
        return new LoginService(); // 의존성, 구성 부품이 추가되면 () 안에 작성
    }
}