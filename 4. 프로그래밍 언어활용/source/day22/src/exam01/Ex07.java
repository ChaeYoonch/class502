package exam01;

import java.io.File;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/fstudy/sub1/sub2/sub3/test1.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath); // 전체경로 - D:\fstudy\sub1\sub2\sub3\test1.txt

        // D:/fstudy/test1.txt 와 D:/fstudy/sub1/sub2/sub3/../../../test1.txt 동일
        File file2 = new File("D:/fstudy/sub1/sub2/sub3/../../../test1.txt"); // absolutePath = 전체 경로
        String absolutePath2 = file2.getAbsolutePath(); // 절대 경로
        System.out.println(absolutePath2); // 경로 - D:\fstudy\sub1\sub2\sub3\..\..\..\test1.txt (1)
        String canonicalPath = file2.getCanonicalPath();
        // canonicalPath - 정규화된 경로 (../../.. 을 D:\fstudy\test1.txt 로 변환해주는 역할
        System.out.println(canonicalPath); // D:/fstudy/test1.txt (2)

        System.out.println("getName() : " + file.getName());
        System.out.println("getPath() : " + file.getPath());
    } // (1) 과 (2) 서로 동일한 경로
}
