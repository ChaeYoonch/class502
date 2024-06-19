package org.choongang.member.services;

import org.choongang.member.validators.JoinValidator;

// 객체 조립기 (회원쪽 기능)
public class MemberServiceProvider { // 싱글톤 패턴 사용
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {} // 기본 생성자 private 로 차단

    public static MemberServiceProvider getInstance() {
        if (instance == null) { // 싱글톤 - 필요할 때 1번만 만들어 공유
            instance = new MemberServiceProvider();
        }

        return instance;
    }

    public JoinValidator joinValidator() { // 회원가입 검증 Validator
        return new JoinValidator();
    }

    public JoinService joinService() {
        return new JoinService(joinValidator());
    }
}