package exam02;

import java.util.HashMap;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>(); // HashMap = 검색이 목적
        members.put("user01", "사용자01"); // user01 = 값을 찾기 위한 키워드
        members.put("user02", "사용자02");
        members.put("user03", "사용자03");
        members.putIfAbsent("user03", "(수정)사용자03"); // 없을 때만 추가, 있을 때는 추가되지 않음

        HashMap<String, String> members2 = new HashMap<>();
        members2.put("user04", "사용자04");
        members2.put("user05", "사용자05"); // putAll 로 통합

        members.putAll(members2); // members 에 members 가 통합됨
        // members.put("user05","(수정)사용자05");
        members.replace("user05", "(수정)사용자05");
        members.remove("user05");

        String userNm = members.get("user03");
        System.out.println(userNm);

        String userNm2 = members.getOrDefault("user06", "없음");
        System.out.println(userNm2);

        System.out.println(members); // members.toString() -> {키 = 값} 형태로 결과 도출
    }
}
