package exam02;

public class Board {
    private static Board instance;

    private Board() {}

    public static Board getInstance() {
        synchronized (Board.class) {
            if (instance == null) {
                instance = new Board();
            }

            return instance;
        }
    }
} // 동기화 블록 사용한 싱글톤 패턴 완성!
