package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 정의에 불과했던 Student.java의 내용이 공간을 가지게 됨 | s1 = main 안에 정의 -> 지역변수
        s1.id = 1000; // ' 인스턴스 ' 변수
        s1.name = "이이름";
        s1.subject = "자바"; // s1의 id, name, subject -> 힙 영역

        s1.study(); // ' 인스턴스 ' 메서드

        Student s2 = new Student();
        s2.id = 1001;
        s2.name = "김이름";
        s2.subject = "자바스크립트";

        s2.study();

        System.out.println(s1 == s2);  // 주소가 서로 다른 객체

        Student s3 = s2; // s3 -> s2 의 값 복사 (주소값을 가지게 됨)
        s3.name = "(수정)김이름";
        s3.study();

        s2.study();
        System.out.println(s3 == s2); // 주소만 같음

        s1 = null;
        s1.study();
    }
}
