package exam01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis(); // 작업 시작 시간 | 현재 시간 1000분의 1초로
        try(FileInputStream fis = new FileInputStream("test final.zip");
            FileOutputStream fos = new FileOutputStream("test final_copied2.zip")) {

            while (fis.available() > 0) {
                fos.write(fis.read()); // 1바이트씩 읽고 쓰기
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis(); // 작업 완료 시간
        System.out.printf("걸린 시간: %d%n", etime - stime);
    }
}
