package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("사과", "배", "오렌지", "망고", "멜론");
        String[] selected = fruits.stream()
                .peek(System.out::println) // 메서드 참조
                .skip(2)
                .limit(2)
                // .toArray(i -> new String[i]); // 사과, 배 건너 뛰고 | 오렌지, 망고 가져옴 | 배열 형태로
                .toArray(String[]::new);
        System.out.println(Arrays.toString(selected));
    }
}
