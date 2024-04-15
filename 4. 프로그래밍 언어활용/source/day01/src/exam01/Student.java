package exam01;

public class Student {
    int id; // 학번 | 변수 정의
    String name; // 학생 이름 | 변수 정의
    String subject; // 과목명 | 변수 정의
    // 아직 정의만 되었을 뿐, 변수는 아님! (class = 설계도면 상태)
    void study() {
        System.out.println(name + "가" + subject + "를 공부한다.");
    }
}
