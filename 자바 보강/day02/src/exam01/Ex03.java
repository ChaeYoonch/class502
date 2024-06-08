package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 내부에서 객체 생성 -> 멤버 변수 초기화 발생
        s1.study(); // id=1000, name=이이름, subject=과목1
        // 변수 만든 이유? -> 쓸려고 생성 -> 값을 넣어줌

        Class cls = Student.class; // Class 클래스
    }
}
