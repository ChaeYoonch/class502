package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex09 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("abc", "def", "ghi");

        // String[] upperAlpha = alpha.stream().map(String::toUpperCase).toArray(i -> new String[i]); // 대문자로 변환
        String[] upperAlpha = alpha.stream().map(String::toUpperCase).toArray(String[]::new); // 위의 것과 동일
        System.out.println(Arrays.toString(upperAlpha));
    }
}
