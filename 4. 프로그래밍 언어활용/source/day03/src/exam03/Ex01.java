package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Board b1 = new Board();
        Board b2 = new Board(); // 통제 X -> 호출 못하도록 막아야 함! | 생성자 -> 접근 제어자 사용
        System.out.println(b1 == b2); // b1 & b2 서로 다른 객체 -> false
    }
}
