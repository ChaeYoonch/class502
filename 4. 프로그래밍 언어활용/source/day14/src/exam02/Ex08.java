package exam02;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int[] nums = { 22, 11, 10, 2, 6, 8, 33};
        Arrays.stream(nums).map(x -> x * x).filter(x -> x % 2 == 1).forEach(System.out::println);
        // predicate 가 매개변수 | 중간 연산 : map & filter | 최종 연산 : forEach 호출 후
    }
}
