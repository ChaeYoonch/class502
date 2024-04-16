package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이이름", "자바"); // Student() 의 () 안에 기본 생성자가 없어서 문제 발생
        s1.study(); // 함수가 실행되려면 우선 객체가 먼저 생성되어야 한다.

        Student s2 = new Student(1001, "김이름", "리액트");
        s2.study();
        // System.out.println(System.identityHashCode(s1)); java -> JDM 언어로 변환 과정에서 나오는 주소 = 4byte 로 공간이 같음
    }
}