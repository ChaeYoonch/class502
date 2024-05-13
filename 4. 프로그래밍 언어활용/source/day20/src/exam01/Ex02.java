package exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test2.txt")) { // 결과-> ìëíì¸ì.
            while(fis.available() > 0) { // fis.available() > 0 -> 읽을 것이 있음
                System.out.print((char)fis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
