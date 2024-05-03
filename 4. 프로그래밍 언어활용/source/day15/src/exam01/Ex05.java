package exam01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = IntStream.generate(() -> 1).limit(10).toArray();
        // IntStream.generate(() -> 1) 무제한 스트림 -> limit 로 제한
        System.out.println(Arrays.toString(nums));
    }
}
