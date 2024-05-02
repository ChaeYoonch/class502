package exam02;

import java.util.stream.IntStream;

public class Ex13 {
    public static void main(String[] args) {
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println("반복 + i");
        } // 아래와 동일한 내용
         */
                      // 0 ~ 9까지 | 0 ~ 10 미만
        IntStream.range(0, 10).forEach(i -> System.out.println("반복" + i));
    }
}
