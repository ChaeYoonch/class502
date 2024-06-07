package exam01;

public class Ex01 {
    public static void main(String[] args) { // main 함수, 시작점
        Student s1 = new Student(); // 클래스명 변수명 = new 클래스명; -> 객체가 됨 | 공간을 할당 받음 | 스택에서 할당
        // Student 의 변수에 대한 정의 가 실제 변수가 됨 => s1.id, s1.name, s1.subject / s1 이라는 자료형으로 사용 가능
        s1.id = 1000; // id, name, subject = 객체 안에 소속된 변수 = 멤버 변수 | 힙에서 할당
        s1.name = "이이름"; // 힙에서 할당
        s1.subject = "과목1"; // 정의에 불과했던 것이 실제 존재하는 객체가 됨 => 인스턴스 | 힙에서 할당
        System.out.println("s1: " + System.identityHashCode(s1)); // s1의 주소값 -> s1: 990368553

        Student s2 = new Student(); // 스택에서 할당받음 | 변수에는 주소만 담겨있음 -> 참조 자료형
        s2.id = 1001;
        s2.name = "김이름";
        s2.subject = "과목2";
        System.out.println("s2: " + System.identityHashCode(s2)); // s2의 주소값 -> s2: 1828972342

        s1.study(); // (id=%d, name=%s, subject=%s%n", id, name, subject) 결과 -> id=1000, name=이이름, subject=과목1
        s2.study();

        Student s3 = s2; // s3에는 s2가 가지고 있는 주소 값이 대입 | s3 과 s2 는 서로 주소값이 같음

        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s2 == s3:" + (s2 == s3));

        s3.name = "박이름";
        System.out.println("s3: -----");
        s3.study();

        System.out.println("s2: -----");
        s2.study();
    }
}
