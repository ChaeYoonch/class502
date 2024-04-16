package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day; // private 접근제어자 -> 내부에서 통제하기 위하여

    public void setYear(int _year) {
        year = _year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int _day) {
        if (month ==2 && _day > 28) {
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
