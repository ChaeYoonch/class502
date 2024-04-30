package exam02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex03 {
    public static void main(String[] args) {
        // HashMap<String, String> members = new HashMap<>(); // HashMap = 검색이 목적 | 다형성 -> 공통적인 틀로 사용
        Map<String, String> members = new TreeMap<>();
        members.put("user01", "사용자01"); // user01 = 값을 찾기 위한 키워드
        members.put("user02", "사용자02"); // (key 값, value 값);
        members.put("user03", "사용자03");
        members.put("user04", "사용자04");
        members.put("user05", "사용자05"); // ket 값 기준으로 정렬 = TreeMap

        Set<Map .Entry<String, String>> entries = members.entrySet();

        for (Map.Entry<String, String> entry : members.entrySet()) { // for (Map.Entry<String, String> entry : entries) {}
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("아이디: %s, 회원명: %s%n", key, value); // 아이디: ..., 회원명: ... 순으로 결과 도출
        }
    }
}
