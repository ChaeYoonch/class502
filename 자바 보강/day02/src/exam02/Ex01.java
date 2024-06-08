package exam02;

public class Ex01 {
    public static void main(String[] args) { // 접근 제어자 : 접근 범위 한정 -> public
        Schedule s1 = new Schedule();
        // s1.year = 2024; -> 멤버 변수(year, month, day)에 바로 값 대입
        // s1.month = 2; = 대입하자 마자 값이 저장되므로 잘못된 값을 통제할 수 있는 수단이 없음 => 통제 불가
        // s1.day = 31;

        // set 메서드 정의 -> 값 사용
        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31);

        int month = s1.getMonth(); // get + 멤버변수명
        System.out.println(month);

        s1.showDate(); // 대입한 날짜 출력 | year=2024, month=2, day=31
        // Schedule 의 setDay 로 통제 후 -> year=2024, month=2, day=28
    }
}
