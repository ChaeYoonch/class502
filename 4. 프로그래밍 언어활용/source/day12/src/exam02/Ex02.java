package exam02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Ex02 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>(); // HashMap = 검색이 목적
        members.put("user01", "사용자01"); // user01 = 값을 찾기 위한 키워드
        members.put("user02", "사용자02"); // (key 값, value 값);
        members.put("user03", "사용자03");

        Set<String> keys = members.keySet();
        Collection<String> values = members.values();
        System.out.println("keys : " + keys); // keys : [...]
        System.out.println("values : " + values); // values : [...]
    }
}
