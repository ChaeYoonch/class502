package exam01;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) { // i 는 0부터 6까지 1씩 추가하며, 반복
            int num = rand.nextInt();
            System.out.println(num);

            boolean bool = rand.nextBoolean();
            System.out.println(bool);
        }
    }
}
