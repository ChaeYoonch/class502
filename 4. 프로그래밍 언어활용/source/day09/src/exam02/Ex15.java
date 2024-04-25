package exam02;

import java.util.Arrays;

public class Ex15 {
    public static void main(String[] args) {
        String str = "Apple Mango     Melon Banana";
        String[] fruits = str.split("\\s+"); // 1개 이상의 공백
        System.out.println(Arrays.toString(fruits));
    }
}
