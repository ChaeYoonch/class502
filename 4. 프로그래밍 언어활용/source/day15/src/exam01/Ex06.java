package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex06 {
    public static void main(String[] args) {
        IntStream stm1 = IntStream.rangeClosed(1, 50); // 1부터 50까지 있는 스트림 객체
        IntStream stm2 = IntStream.rangeClosed(51, 100); // 51부터 100까지 있는 스트림 객체 | 둘을 결합하면 1 ~ 100 -> concat
        IntStream stm = IntStream.concat(stm1, stm2); // 1부터 100까지의 객체 | 결합
        int[] nums = stm.toArray(); // 1 ~ 100
        System.out.println(Arrays.toString(nums));
    }
}
