package exam01;

import java.util.Calendar;

public class Ex01 { // public class -> 파일명과 동일한 것이 1개는 무조건 있어야 함
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); // 정적 메서드 getInstance()
        printDate(cal);

        // cal.set(Calendar.MONTH, 11); // 12월
        cal.add(Calendar.DAY_OF_MONTH, 150); // 150일 후로 변경 | 양수이면 더하고 음수이면 뺌

        printDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, -100); // 100일 전으로 변경
        printDate(cal);
    }

    public static void printDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11 / 1월 -> 0
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, day=%d%n", year, month + 1, day);
    }
}
