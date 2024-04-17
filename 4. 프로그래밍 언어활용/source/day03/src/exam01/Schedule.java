package exam01;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public Schedule() {
        /* year = 2024; month = 4; day = 17; */
        this(2024, 4, 17);
    }

    public Schedule(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year; // 원래 return this.year 이지만, 명확하기 때문에 생략 O
    }

    public void setYear(int year) {
        this.year = year;  // this. year = 힙 영역에 있는 인스턴스 변수(=멤버 변수) year | year = 스택 영역에 있는 지역변수 year
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    } // 설정하기 위해 객체의 자원 활용

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (this.month == 2 && day > 28) {
            day = 28;
        }

        this.day = day; // this -> 함수 안에 존재하는, 객체의 자원을 사용할 수 있는 지역변수 | 한 번 값이 정해지면 바뀌지 않음
    } // 값에 대한 통제 가능! | this.day = 객체 자원

    void showDate() {
        System.out.printf("year = %d, month = %d, day = %d%n", year, month, day);
        // 원래 : year = this.year, month = this.month, day = this.day 이지만, 객체 자원 = 멤버 변수가 명확하므로 this 생략 O
        printThis(); // 원래 = this.printThis(); 명확하기 때문에 this 생략해도 동일하게 동작 O
    }

    public void printThis() {
        System.out.println(this);
    }

    public Schedule returnThis() {
        return this;
    }  // 함수의 this = 주소값 O | 객체의 자원 = 변수

    @Override
    public String toString() {
        return "Schedule{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
