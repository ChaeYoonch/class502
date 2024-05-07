package exam02;

import java.util.Date;

public class Ex01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonth(); // 0 ~ 11
        System.out.printf("year=%d, month=%d%n", year, month + 1); // month 로 하면 4가 나옴 | 0 ~ 11 이므로 4 = 5월
        long epochTime = date.getTime(); // 1970.01.01 자정, 1000분의 1초 단위로 카운팅 -> 1715067782364
        System.out.println(epochTime); // UID (Unique ID)를 만들때 자주 활용
    }
}
