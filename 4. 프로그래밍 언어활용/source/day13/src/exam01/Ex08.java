package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "이름1", "이름2", "이름3"); // 한꺼번에 추가 가능 -> , 로 나열
        System.out.println(names); // names 출력
    }
}
