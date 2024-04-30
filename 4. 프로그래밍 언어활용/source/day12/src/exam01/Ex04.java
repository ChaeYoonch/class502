package exam01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex04 {
    public static void main(String[] args) {
        // HashSet<String> names = new HashSet<>(); // Hash = '검색'이 주 목적 | 중복 제거 O but, 정렬 X

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // return o1.compareTo(o2); // 오름차순
                // return o2.compareTo(o1); // 내림차순
                return o1.compareTo(o2) * -1; // 내림차순 위의 식과 동일
            }
        };

        // Set<String> names = new TreeSet<>(comp); // TreeSet<String> names = new TreeSet<>(); -> 다형성으로 Set 변경
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());
        names.add("이름1");
        names.add("이름2");
        names.add("이름2"); // 중복이 제거되어 나옴
        names.add("이름3");
        names.add("이름4");
        names.add("이름5"); // but, 이름의 순서를 바꿔도 결과값은 이름3, 이름2, 이름1, 이름5, 이름4 순으로 나타남
        System.out.println(names); // names.toString() -> toString = 값 확인
    }
}
