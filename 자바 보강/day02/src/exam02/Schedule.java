package exam02;

public class Schedule {
    private int year; // 년 | 따로 정의하지 않음 -> 디폴트 default
    private int month; // 월 | 따로 정의하지 않음 -> 디폴트 default
    private int day; // 일 | 따로 정의하지 않음 -> 디폴트 default
    // int 앞에 private 로 접근 범위 통제 -> Ex01 에서 사용 불가능하므로 오류 발생 -> set 으로 변수의 값 설정
    public void setYear(int _year) {
        year = _year; // 내부에서 값 설정
    }

    public int getYear() { // 값만 조회하므로 매개변수 필요 X
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int _day) {
        if (month == 2 && _day > 28) { // 만약 month 가 2월이고, _day 가 28일보다 크다면 _day 는 28로 고정
            _day = 28;
        }

        day = _day;
    }

    public int getDay() {
        return day;
    }

    void showDate() {
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
