package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex12 {
    public static void main(String[] args) {
        int[] nums = { 33, 10, 5, 1, 3, 88, 100, 10 };
        int[] nums2 = Arrays.stream(nums).sorted().toArray(); // 최종 연산 : 정렬 후 새로운 배열 생성 | 오름차순
        System.out.println(Arrays.toString(nums2)); // sorted = Intstream 에 정의된 기능
        // Stream 의 <Integer> 로 변환되어 있음
        int[] nums3 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
        // boxed 을 사용해 일반 스트림으로 변경
        System.out.println(Arrays.toString(nums3));
    }
}
