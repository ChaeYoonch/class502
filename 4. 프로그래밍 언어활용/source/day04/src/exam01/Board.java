package exam01;

public class Board { // 싱글톤 패턴 예제 | 외부에 객체 생성 불가 -> static 붙이면 객체 상관 없이 접근 가능 메서드 정의 O
     // private static Board instance = new Board(); // 클래스 로드 시점부터 객체 생성
    // 클래스 내부에서 생성 => 2번째 원칙 | 따라서 private 뒤에 static 붙이면 됨
    private static Board instance; // 지금은 변수만 선언 => 필요할 때 1번 생성 그 후 공유

    static {
        System.out.println("처음부터 실행, 객체 생성과 관련 없이");
    }

    private Board() {} // 생성자를 private 로 막음 => 1번째 원칙

    public static Board getInstance() { // static -> 정적 자원만 접근 가능 메서드
        if (instance == null) { // 필요한 시점 최초 1번만 생성
            instance = new Board();
        }

        return instance; // 클래스 내부에 생성된 객체를 반환하는 함수 필요 => 3번째 원칙
    }
}
