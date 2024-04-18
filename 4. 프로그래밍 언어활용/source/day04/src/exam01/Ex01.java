package exam01;

public class Ex01 {
    public static void main(String[] args) { // 생성자의 접근 제어자 범위 : 현재 public
        /* Board b0 = new Board(); */
        Board b1 = Board.getInstance();
        Board b2 = Board.getInstance(); // b1 & b2 서로 다른 공간에 생성 = 서로 다른 주소 | getInstance 로 변경 뒤에는 동일
        System.out.println(b1 == b2);
        System.out.println("b1 주소 : " + System.identityHashCode(b1));
        System.out.println("b2 주소 : " + System.identityHashCode(b2));

    }
}
