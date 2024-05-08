package exam01;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // cal.add(Calendar.MONTH, 30); // 30개월 후 -> 전부 추가됨
        cal.roll(Calendar.MONTH, 30); // 30개월 후 -> MONTH 만 계속 반복함
        printDate(cal);
    }

    public static void printDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11 / 1월 -> 0
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, day=%d%n", year, month + 1, day);
    }
}
