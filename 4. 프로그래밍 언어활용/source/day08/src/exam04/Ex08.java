package exam04;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40};
        int[] nums2 = Arrays.stream(nums).map(x -> x * x).toArray();
        System.out.println(Arrays.toString(nums2));
    }
}
