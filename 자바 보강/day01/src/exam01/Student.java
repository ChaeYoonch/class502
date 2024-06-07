package exam01;

public class Student {
    // 변수에 대한 정의 -> 실제 변수는 아님! | 변수 => 공간의 이름 = 메모리를 찾아가는 이름, 메모리 할당 + 이름 있어야 변수라고 함
    int id; // 학번
    String name; // 학생명
    String subject; // 전공 과목

    // 기본 생성자 함수 (없으면 안되므로 컴파일러가 기본으로 추가함)
    public Student() {

    }

    // 행위에 대한 정의
    void study() {
        System.out.printf("id=%d, name=%s, subject=%s%n", id, name, subject); // 변수 -> 기능에 대한 부분 정의

        boolean result = true;
        if (result) {
            return;
        }

        System.out.println("실행2"); // return 뒤에 있으므로 배제됨
    } // 객체 X -> 객체가 되기 위한 설계도
} // 클래스에 대한 정의에서 가장 중요한 것 => 다른 객체에 대한 협력 -> 서로 영향을 주고 받음 = " 함수 = 메서드 "