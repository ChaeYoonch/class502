package exam02;

public class Schedule2 {
    private int year;
    private int month;
    private int day;

    public Schedule2() { // 기본 생성자 -> 생성자 오버로드가 가능하므로 사용할 수 있음
        /* year = 2024; month = 6; day = 8; */
        this(2024, 6, 8); // this 호출 시 아래의 this.year, this.month, this.day 정의된 것 가져옴
    }

    public Schedule2(int year, int month, int day) { // 지역변수 year 와 멤버변수 year 가 동일 | 멤버 변수에 초기화
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year; // 원래는 return this.year; 지만, year 하나 밖에 없으므로 멤버 변수로 특정 지어지기에 this 생략 가능
    }

    public void setYear(int year) { // System.out.println("this : " + this); // this : Schedule2{year=0, month=0, day=0}
        this.year = year; // year : 지역 변수 year 와 멤버 변수 year 2개가 있으므로 앞의 year 에는 this 를 붙여줘야 함
    } // 앞의 year : 멤버 변수, 뒤의 year : 지역 변수

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day; // this = 메서드 안에서 객체에 접근할 수 있는 수단 -> 객체의 주소값 | 객체가 된 이후에 this 값이 결정되어 있음
    } // 클래스 내부 = 메서드 안에서 -> 객체의 자원 (인스턴스 메서드)에 접근하기 위해 내부에서 정의된 지역변수 주소가 필요 <= this 의 역할

    public Schedule2 getThis() {
        return this;
    }

    @Override
    public String toString() {
        return "Schedule2{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}'; // year -> this.year / month -> this.month / day -> this.day 가 원래 형태
    }
}
