package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex02 {
    public static void main(String[] args) {
        // throw new FileNotFoundException(...)
        try {
            FileInputStream fis = new FileInputStream("b.txt");

            System.out.println("파일 처리...");

        } catch (FileNotFoundException e) { // e = new FileNotFoundException
            System.out.println("예외 발생!");
            // String message = e.getMessage();
            // System.out.println(message); // 지정된 파일을 찾을 수 없습니다
            e.printStackTrace();
        }

        System.out.println("매우 중요한 실행 코드 ....");
    }
}
