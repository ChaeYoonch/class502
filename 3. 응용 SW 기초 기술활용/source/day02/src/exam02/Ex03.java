package exam02;

public class Ex03 {
    public static void main(String[] args) {
        //int[] nums = new int[] {10, 20, 30, 40}; // 값의 수에 따라 공간 개수 지정됨 => 4 | 선언과 동시에 초기화 | 0, 1, 2, 3
        //int[] nums; // 분리해서 쓸 때는 형식 제대로 갖춰야 함
        // nums = new int [] {10, 20, 30, 40};
        //nums = {10, 20, 30, 40}; // 오류

        int[] nums = { 10, 20, 30, 40 }; // 선언과 동시에 초기화시에만 가능 | 총 7개
        System.out.println("공간의 갯수 : " + nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
