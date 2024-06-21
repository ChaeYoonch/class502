package org.choongang.global.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest req) {
        super((HttpServletRequest) req); // (HttpServletRequest) 로 형변환

        HttpServletRequest request = (HttpServletRequest) req;

        /* 로그인 상태, 로그인 회원 정보 전역 유지 */
        boolean isLogin = MemberUtil.isLogin(request); // 로그인 정보
        Member member = MemberUtil.getMember(request); // 회원 정보

        request.setAttribute("isLogin", isLogin); // EL 식 속성 -> 모든 jsp 페이지에서 접근 가능
        request.setAttribute("loggedMember", member); // EL 식 속성 -> 모든 jsp 페이지에서 접근 가능
    }
}