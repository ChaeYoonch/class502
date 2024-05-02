package exam02;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        String[] names = {"이름3", "이름2", "이름1"};
        Arrays.sort(names); // sort -> 정렬
        System.out.println(Arrays.toString(names)); // System.out.println(names); -> [Ljava.lang.String;@3b07d329
    }
}
