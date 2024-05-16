package exam01;

import java.io.File;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) throws IOException, InterruptedException { // throws -> 실행 한 쪽이 처리
        File tmpFile = File.createTempFile("tmp", ".log", new File("D:/fstudy"));
        // tmpFile.delete(); // 바로 삭제
        tmpFile.deleteOnExit(); // 애플리케이션이 종료되면 삭제

        Thread.sleep(5000); // 5초지연시킴
        System.out.println("종료!");
    }
}
