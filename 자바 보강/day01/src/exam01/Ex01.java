package exam01;

public class Ex01 {
    public static void main(String[] args) { // main 함수, 시작점
        Student s1 = new Student(); // 클래스명 변수명 = new 클래스명; -> 객체가 됨 | 공간을 할당 받음
        // Student 의 변수에 대한 정의 가 실제 변수가 됨 => s1.id, s1.name, s1.subject / s1 이라는 자료형으로 사용 가능
        s1.id = 1000; // id, name, subject = 객체 안에 소속된 변수 = 멤버 변수
        s1.name = "이이름";
        s1.subject = "과목1"; // 정의에 불과했던 것이 실제 존재하는 객체가 됨 => 인스턴스

        s1.study();
        // (id=%d, name=%s, subject=%s%n", id, name, subject) 결과 -> id=1000, name=이이름, subject=과목1
    }
}
