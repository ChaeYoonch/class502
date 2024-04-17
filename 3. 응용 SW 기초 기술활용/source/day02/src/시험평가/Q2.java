package 시험평가;

public class Q2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 40; i++) {
            int roomNum = i % 10;
            System.out.printf("학생%d, 방번호 %d번%n", i, roomNum);
        }
    }
}
