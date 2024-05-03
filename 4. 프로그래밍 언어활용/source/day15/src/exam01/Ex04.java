package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(2, x -> x + 2).limit(10).toArray(); // 2씩 증가 10개의 값 -> 배열의 형태
        System.out.println(Arrays.toString(nums));
    }
}
