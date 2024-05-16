package exam01;

import java.io.IOException;
import java.io.PrintStream;

public class Ex02 {
    public static void main(String[] args) throws IOException { // throws IOException 쓰면 new 뒤의 PrintStream 붉은 줄 X
        PrintStream out = new PrintStream("20240516.log"); // 에러 를 20240516.log 파일로 생성되도록 함
        System.setErr(out);

        String str = null;
        str.toUpperCase();
    }
}
