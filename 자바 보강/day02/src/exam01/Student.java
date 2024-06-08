package exam01;

public class Student { // 변수 & 함수 정의 -> 객체 구성요소
    // 변수 정의 | 메모리(공간)이 할당되지 않았기에 변수라고 할 수 없음 -> 단순 코드!!
    static int id; // 학번
    String name; // 학생명
    String subject; // 과목

    public Student() { // 컴파일러가 기본 생성자 자동 추가 | 없으면 객체가 되기 위한 수단이 필요하기 때문에 무조건 생성됨
        // 생성자 함수 = 생성자 메서드 | 함수명이 클래스명과 같음 | 반환값 타입 명시 X
        // public 과 Student() 사이의 반환값 타입이 없음 -> 생성자의 반환값은 바뀌면 안되기 때문에 통제되고 있음
        // => 그러므로 따로 명시하지 않음 | return 예약어도 사용 불가
        // 객체 생성된 이후 실행되는 부분 -> 공간 할당 받음 -> 실제 변수가 되는 시점 -> id, name, subject 가 이미 변수가 된 상태
        // 멤버 변수의 초기화 작업을 주로 많이 정의
        id = 1000;
        name = "이이름";
        subject = "과목1";
    } // 얘를 없애면 기본 생성자를 없애는 것이므로 주석처리하면 오류 발생
    // 기본 생성자 : 객체를 생성할 수 있는 생성자가 없는 경우에만 추가, 비어있는 매개변수가 없을 때, 객체가 안되기 때문에 컴파일러가 추가
    // 생성자를 추가하면 컴파일러가 추가하지 않음

    // 생성자 오버로드 | 시그니처를 다르게 하면 여러 개 정의 가능
    public Student(int _id, String _name, String _subject) { // int _id, String _name, String _subject : 지역변수
        // 실행 과정에서 멤버 변수에 지역 변수 대입
        id = _id;
        name = _name;
        subject = _subject;
    } // 지역변수 : 실행될 때, 생성자 매개변수로 투입된 값 -> 최초로 대입하는 초기화 작업
    // 변수 정의 (객체가 되면 사용할 수 있는 변수 = 인스턴스 변수 = 멤버변수)

    // 함수 정의
    void study() {
        System.out.printf("id=%d, name=%s, subject=%s%n", id, name, subject);
    }
}
