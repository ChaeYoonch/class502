package exam02;

public class Ex01 { // exam02.Ex01 -> 클래스명
    public static void main(String[] args) {
        Schedule s1 = new Schedule(); // Schedule -> exam02.Schedule 로 표시해야 하지만, 같은 패키지일 경우 패키지명 생략 가능
        s1.year = 2024;
        s1.month = 2;
        s1.day = 31; // 직접 대입 -> 지양 => why? 통제가 불가하기 때문

        s1.showDate();
    }
}
