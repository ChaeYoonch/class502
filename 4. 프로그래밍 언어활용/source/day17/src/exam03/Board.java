package exam03;

public class Board {

    private static Board instance; // 처음 -> 비어있는 공간 | 객체와 상관없이 접근할 수 있는 공간

    private Board() {}

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
}
