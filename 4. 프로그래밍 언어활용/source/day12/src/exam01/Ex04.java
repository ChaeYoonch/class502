package exam01;

import java.util.HashSet;

public class Ex04 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>(); // Hash = '검색'이 주 목적
        names.add("이름1");
        names.add("이름2");
        names.add("이름2"); // 중복이 제거되어 나옴
        names.add("이름3");
        names.add("이름4");
        names.add("이름5"); // but, 이름의 순서를 바꿔도 결과값은 이름3, 이름2, 이름1, 이름5, 이름4 순으로 나타남
        System.out.println(names); // names.toString() -> toString = 값 확인
    }
}
