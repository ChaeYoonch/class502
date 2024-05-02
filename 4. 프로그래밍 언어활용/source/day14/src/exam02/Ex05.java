package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = { 22, 11, 15, 35, 40, 77};

        IntStream stm = Arrays.stream(nums);
        int total = stm.map( x -> x * x).sum(); // 제곱 & 합계
        System.out.println(total);

        stm = Arrays.stream(nums); // 또 사용하려면 stream 새로 정의해야 함!
        int total2 = stm.map( x -> x * x * x).sum();
        System.out.println(total2); // stream = 1회용 | 2번 이상 사용 불가!!
    }
}
