package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test1.txt", true)) { // append -> true 이면 커서가 맨끝에 위치
            for (char ch = 'A'; ch <= 'Z'; ch++) { // 문자열 A 부터 시작, Z보다 작거나 같을 때까지, 증가
                fos.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
