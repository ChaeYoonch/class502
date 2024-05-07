package exam01;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int firstOdd = rand.ints(100)
                            .filter(x -> x % 2 == 1)
                            .findFirst()
                            .orElse(-1); // 홀수 거름 | finalFirst = 값이 없을 가능성이 있음
        System.out.println(firstOdd);
    }
}
