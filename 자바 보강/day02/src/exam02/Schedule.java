package exam02;

public class Schedule {
    int year; // 년 | 따로 정의하지 않음 -> 디폴트 default
    int month; // 월 | 따로 정의하지 않음 -> 디폴트 default
    int day; // 일 | 따로 정의하지 않음 -> 디폴트 default

    void showDate() {
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
