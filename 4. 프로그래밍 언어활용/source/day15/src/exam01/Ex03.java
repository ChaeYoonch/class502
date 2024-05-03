package exam01;

import java.util.Random;

public class Ex03 {
    public static void main(String[] args) {
        Random rand = new Random();

        rand.ints().limit(6).forEach(System.out::println); // 정수 범위에서 6자리 숫자 랜덤
        // rand.ints(6).limit().forEach(System.out::println);
    }
}
