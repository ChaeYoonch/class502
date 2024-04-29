package exam04;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(); // 순서에 특화 = for 문
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        /* for (int i = 0; i < names.size(); i++) {
            names.remove(i);
        } */

        for (int i = names.size() - 1; i > 0; i--) {
            names.remove(i);
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        } // 결과 = 이름1 이름2 이름3 이름4 이름5 세로 줄로 나옴 -> 순서 보장됨!! | 순차 자료 구조
        // System.out.println(names); // names.toString(); -> 담긴 값을 확인할 수 있도록 재정의
        // 결과값 = [이름1, 이름2, 이름3, 이름4, 이름5]
    }
}
