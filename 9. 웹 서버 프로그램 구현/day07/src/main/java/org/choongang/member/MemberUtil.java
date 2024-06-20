package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.member.entities.Member;

public class MemberUtil {

    public static boolean isLogin(HttpServletRequest request) {
        return getMember(request) != null; /*  안의 내용과 동일한 역할 */
        /* Member member = getMember(request);
        return member != null; */
    } // session 에 member 가 있으면 로그인 상태 | null O = 로그인 상태 , null X = 비로그인 상태

    public static Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

        return member;
    }
}