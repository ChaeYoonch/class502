package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // s1 -> 지역 변수 - 스택 영역
        Student s1 = new Student(); // 변수에 대한 공간 할당 -> 실제 변수가 된 것! | 참조 변수 s1 을 통해 접근 가능

        // 멤버 변수, 인스턴스 변수 - 힙 영역
        s1.id = 1000; // 값이 대입 됨 => 공간을 할당 받은 것
        s1.name = "이이름";
        s1.subject = "과목1";

        s1.study(); // id=1000, name=이이름, subject=과목1 => 실제 메모리에 존재함 -> 인스턴스
        System.out.println(System.identityHashCode(s1)); // 189568618
    } // main 내의 변수 = 4개 -> s1 : 참조 변수 = 지역변수 / id, name, subject : 멤버 변수 = 인스턴스 변수 (객체가 만들어져야 하는 변수)
} // => s1 : 스택 메모리 영역 | id, name, subject : 힙 메모리 영역
