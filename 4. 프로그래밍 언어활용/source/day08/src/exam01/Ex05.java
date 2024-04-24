package exam01;

import java.util.HashSet;

public class Ex05 {
    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>(); // 내부에서 비교해보고 중복된 내용 배제하는 방식
        data.add("AAA");
        data.add("BBB");
        data.add("AAA");
        data.add("CCC");
        System.out.println(data);
    }
}
