package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "mango", "melon"); // map -> 변환작업
        fruits.stream().map(s -> "*" + s + "*").map(String::toUpperCase).forEach(System.out::println);
                        // 중간 연산             // 중간 연산               // 최종 연산
        System.out.println(fruits);
    }
}
