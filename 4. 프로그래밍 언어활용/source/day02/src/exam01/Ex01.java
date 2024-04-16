package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 정의에 불과했던 Student.java의 내용이 공간을 가지게 됨
        s1.id = 1000; // ' 인스턴스 ' 변수
        s1.name = "이이름";
        s1.subject = "자바";
        System.out.println(s1.id);
        s1.study(); // ' 인스턴스 ' 메서드
    }
}
