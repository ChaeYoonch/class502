package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("b.txt"); // b.txt -> FileNotFoundException 으로 유입됨!

            System.out.println("파일 작업...");

        } catch (IOException e) {
            // FileNotFoundException 의 상위 클래스가 IOException 이기에 IOException 을 대신 쓰면 fis.close 에 오류 발생 X
            e.printStackTrace();
        } finally {
            System.out.println("무조건 실행!");
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
