package exam01;

public class Student { // 파일명과 동일한 클래스명 생성 | id, name, subject -> 멤버 변수
    int id; // 학번 | 아직 변수 X
    String name; // 이름 | 아직 변수 X
    String subject; // 과목 | 아직 변수 X / 변수 = 공간 (메모리) + 이름

    public Student() {
        id = 1000;
        name = "이이름";
        subject = "자바";
    }

    public Student(int _id, String _name, String _subject) { // 기본 생성자(Default 생성자)
        // int ~ _subject 처럼 () 안의 내용 즉, 기본생성자는 객체를 만들 수 없을 때만 추가
        // (_id, _name, _subject) -> 실행 과정 중 스택 영역에서 할당받는 지역변수 | 객체를 만드는 역할 -> 객체가 되야만 사용 가능
        id = _id;
        name = _name;
        subject = _subject; // id, name, subject -> 힙 영역에서 할당받음
        // 객체가 생성된 이후 실행 코드 | 내부적으로 구성 O 통제못하게 막혀있지만, 객체가 된 이후에 더 해야될 작업 추가로 작성 가능
        // 반환값 없는 게 아님! => 반환값을 내보내면 객체 접근 X => 보이지 않는 상태 | return 키워드 사용 X | 시점 = 객체 생성 이후
        // 실행 시점 : 객체가 된 이후 (= 변수 O) -> 생성자의 역할을 다 한 다음 / id, name, subject 에 공간을 할당 받은 상태
        // System.out.println("객체 생성 이후 실행");
        // 인스턴스 변수의 초기화 작업을 주로 수행 | 생성자의 초기에 값을 넣는 초기화 작업
        // id = 1000;
        // name = "이이름";
        // subject = "자바";
    }

    void study() {
        // 1) 객체 생성 2) 호출 -> 호출 시점에는 인스턴스 변수가 이미 공간 할당
        System.out.printf("학번:%d,%s가 %s를 공부한다.%n", id, name, subject);
        // void = 반환값 (비어있다는 의미) -> 반환값을 따로 지정하지 않음을 의미
        //return; // return 을 중간에 넣으면 실행 흐름을 끊어준다는 의미

        // System.out.println("실행되나요?");
    }
}
