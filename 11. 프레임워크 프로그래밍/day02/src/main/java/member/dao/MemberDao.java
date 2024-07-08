package member.dao;

import member.entities.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao { // memberDao -> 빈 이름

    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member) { // 가입 시 정보 저장
        members.put(member.getEmail(), member);
    }

    public Member get(String email) { // email 로 조회 O
        return members.get(email);
    }

    public List<Member> getList() {
        List<Member> data = new ArrayList<>(members.values()); // .values 가 Collection 형태이므로 앞에 new ArrayList<>() 붙임

        return data;
    }
}