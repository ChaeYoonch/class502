package exam02;

import java.time.LocalTime;

public class Ex07 {
    public static void main(String[] args) {
        LocalTime today = LocalTime.now();
        LocalTime time = LocalTime.of(23, 30, 0); // 직접 생성 가능
        System.out.println(today);
        System.out.println(time);
    }
}
