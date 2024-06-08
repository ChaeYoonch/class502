package exam02;

public class Ex02 {
    public static void main(String[] args) {
        Schedule2 s1 = new Schedule2(); // Schedule2 : 참조 변수 = 주소값 | 요기서 객체가 됨
        s1.setYear(2024); // 인스턴스 메서드 = 객체가 되어 있는 시점 이후에 사용 가능
        s1.setMonth(6); // 객체가 되어야만 접근이 가능한 메서드
        s1.setDay(8); // 생성자의 매개변수로 정의하면 간단함

        System.out.println(s1); // s1.toString(); 메서드 자동 추가 | 객체의 주소값 exam02.Schedule2@3b07d329
        // toString() 메서드 재정의 -> 객체 그 자체로 나타내기 위해 | Schedule2{year=2024, month=6, day=8}
        Schedule2 _this = s1.getThis();
        System.out.println(_this == s1); // true | s1 의 값과 this 의 값이 같음 -> s1 : 객체의 자원을 접근할 수 있는 주소값
        // this 에도 s1과 같은 값이 존재 = 주소가 동일
    }
}
