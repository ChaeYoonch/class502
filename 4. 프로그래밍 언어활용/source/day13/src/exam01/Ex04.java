package exam01;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 40};
        int[] nums2 = {10, 20, 30, 40};

        boolean isSame = Arrays.equals(nums1, nums2); // 1차원 배열만 비교하기 때문에 true 나옴
        System.out.println(isSame);

        int[][] nums3 = { {10, 20, 30}, {40, 50, 60}};
        int[][] nums4 = { {10, 20, 30}, {40, 50, 60}};

        boolean isSame2 = Arrays.equals(nums3, nums4); // 1차원 배열만 비교하기 때문에 false 나옴
        System.out.println(isSame2);

        boolean isSame3 = Arrays.deepEquals(nums3, nums4); // 다차원 배열 비교
        System.out.println(isSame3);

        *
        /* boolean isSame = true;
        for (int i =0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                isSame = false;
                break;
            }
        } */
    }
}
