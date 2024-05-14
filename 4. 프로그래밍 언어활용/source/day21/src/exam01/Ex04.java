package exam01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("score.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            int total = 0, cnt = 0;
            try {
                while (true) {
                    int score = dis.readInt();
                    total += score;
                    cnt++;
                } // true -> 다 읽고 나면 예외 발생 EOFException
            } catch (EOFException e) { // 파일을 다 읽은 상태
                System.out.printf("합계: %d, 평균: %.1f%n", total, total / (double)cnt);
            } // 소수점 첫째자리까지 표기 .?f ?가 소수점 자리수
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
