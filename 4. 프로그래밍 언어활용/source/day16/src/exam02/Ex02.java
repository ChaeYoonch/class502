package exam02;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        /* Calendar cal = new Calendar() 추상 이기에 불가능! */
        printDate(cal);

        cal.set(Calendar.MONTH, 0); // 0 -> 1월 | 원래 객체의 값을 변경

        printDate(cal); // 기존 값이 변경됨
    }

    public static void printDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11 사이이므로 +1 해야 정확하게 나옴!
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.printf("year%d, month=%d, day=%d%n", year, month + 1, day);
    }
}
