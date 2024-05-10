package exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt")) {
            int ch = fis.read(); // 1바이트를 읽어옴 -> 1글자 : 65 = A 의 아스키코드
            System.out.println((char)ch); // 65 -> A 로 바꾸기 위해 형 변환 | 파일포인터 현재 = A 사이 B

            ch = fis.read(); // 1바이트
            System.out.println((char)ch); // int -> char 로 형변환 : B | 위치 이동하면서 읽어옴 | 파일포인터 현재 = B 사이 C

            ch = fis.read(); // 1바이트
            System.out.println((char)ch); // int -> char 로 형변환 : C | 파일포인터 현재 = C 사이 D

            ch = fis.read(); // 1바이트
            System.out.println((char)ch); // int -> char 로 형변환 : D | 파일포인터 현재 = D 사이 E

            ch = fis.read(); // 1바이트
            System.out.println((char)ch); // int -> char 로 형변환 : E | 파일포인터 현재 = E 뒤

            ch = fis.read(); // -1 : 파일을 전부 다 읽음
            System.out.println(ch);
            System.out.println((char)ch);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
