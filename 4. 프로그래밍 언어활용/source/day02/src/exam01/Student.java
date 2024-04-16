package exam01;

public class Student { // 파일명과 동일한 클래스명 생성
    int id; // 학번 | 아직 변수 X
    String name; // 이름 | 아직 변수 X
    String subject; // 과목 | 아직 변수 X / 변수 = 공간 (메모리) + 이름

    void study() {
        System.out.printf("%s가 %s를 공부한다.%n", name, subject);
    }
}
