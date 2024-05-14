package exam01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt");
             DataInputStream dis = new DataInputStream(fis)) {

            byte num = dis.readByte();
            char ch = dis.readChar();
            String str = dis.readUTF(); // 순서가 바뀌면 오류 발생 -> 각각에 정해진 크기가 있는데, 순서가 바뀌면 어그러짐

            System.out.printf("num=%d, ch=%c, str=%s%n", num, ch, str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} // Ex01.java 의 FileOutPutStream 으로 작성한대로 만들어진 test1.txt 에서 읽어옴
