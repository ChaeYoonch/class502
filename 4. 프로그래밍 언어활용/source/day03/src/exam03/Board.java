package exam03;

public class Board {

    private static Board instance = new Board(); // instance 자원, 변수 / 변수가 private 이면 외부에서 호출

    private Board() {}

        public static Board getInstance() { // public Board getInstance -> instance 메서드 => 객체가 반드시 있어야 함!
            return instance;
        }
}
