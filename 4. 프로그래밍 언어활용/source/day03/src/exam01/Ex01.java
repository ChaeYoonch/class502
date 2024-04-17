package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
        /*s1.year = 2024;
        s1.month = 4;
        s1.day = 17; */ // 변수 직업 대입 -> 통제 불가능 => 지양!

        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31);

        s1.showDate(); // 객체가 이미 생성되어 있어야만 함! (이미 생성된 객체의 주소값으로 결정되어 있음)

        s1.printThis(); // exam01.Schedule@10f87f48 -> exam01.Schedule = 클래스명 , @10f87f48 = 객체 주소 16진수
        // System.out.println(s1); // s1.printThis(); & System.out.println(s1); 같은 값 도출
        Schedule _this = s1.returnThis();
        System.out.println(_this == s1); // (인스턴스 메서드의) this 의 주소값 과 s1이 가지고 있는 주소값이 동일
    }
}
