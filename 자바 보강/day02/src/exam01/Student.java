package exam01;

public class Student { // 변수 & 함수 정의 -> 객체 구성요소
    // 변수 정의 | 메모리(공간)이 할당되지 않았기에 변수라고 할 수 없음 -> 단순 코드!!
    int id; // 학번
    String name; // 학생명
    String subject; // 과목

    public Student() { // 컴파일러가 기본 생성자 자동 추가 | 없으면 객체가 되기 위한 수단이 필요하기 때문에 무조건 생성됨
        // 생성자 함수 = 생성자 메서드 | 함수명이 클래스명과 같음
        // public 과 Student() 사이의 반환값 타입이 없음 -> 생성자의 반환값은 바뀌면 안되기 때문에 통제되고 있음
        // => 그러므로 따로 명시하지 않음 | return 예약어도 사용 불가
        // 객체 생성된 이후 실행되는 부분 -> 공간 할당 받음 -> 실제 변수가 되는 시점 -> id, name, subject 가 이미 변수가 된 상태
        // 멤버 변수의 초기화 작업을 주로 많이 정의
        id = 1000;
        name = "이이름";
        subject = "과목1";
    }

    // 함수 정의
    void study() {
        System.out.printf("id=%d, name=%s, subject=%s%n", id, name, subject);
    }
}
