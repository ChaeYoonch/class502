package exam03;

public class Student { // 클래스 = 객체를 만들기 위해 생성 -> 중요한 구성요소인 변수 & 함수 정의한 설계도
    // 변수
    int id;
    String name;
    String subject;

    /* // 따로 정의하지 않아도 기본으로 컴파일러가 기본 생성자 추가 : public Student() {}
    public Student(int _id, String _name, String _subject) {
        id = _id;
        name = _name;
        subject = _subject;
    }
    */
    void study() { // 함수
        System.out.printf("id=%d, name=%s, subject=%s%n", id, name, subject);
    }
}
