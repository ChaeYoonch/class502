package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07 {
    public static void main(String[] args) {
        String str = "java one\njava two\njava three"; // \n : 줄 개행 문자 있지만, "..." 을 한 개의 문장으로 인식할 수 있음
        // Pattern p1 = Pattern.compile("^\\w+\\s"); // \\s : 공백 문자 1개
        Pattern p1 = Pattern.compile("^\\w+\\s", Pattern.MULTILINE); // 여러줄 걸쳐 플래그 패턴 체크
        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group());
        }

        if (m1.find()) {
            System.out.println(m1.group());
        }

        if (m1.find()) {
            System.out.println(m1.group());
        }
        // System.out.println(str);
    }
}
