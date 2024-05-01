package exam01;

import java.util.Arrays;
import java.util.Comparator;

public class Ex07 {
    public static void main(String[] args) {
        //int[] nums = { 22, 10, 5, 1, 99, 50};
        Integer[] nums = { 22, 10, 5, 1, 99, 50};
        // Arrays.sort(nums); // 알아서 기본 정렬, int 자료형 -> Integer 기본 정렬 기분 => java.lang.Comparable, int compareTo()
        // 오름차순
        Arrays.sort(nums, Comparator.reverseOrder()); // 내림차순
        System.out.println(Arrays.toString(nums));
    }
}


