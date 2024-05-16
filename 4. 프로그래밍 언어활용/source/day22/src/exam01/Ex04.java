package exam01;

import java.io.File;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) throws IOException { // throws IOException -> createNewFile 붉은 선 X
        //File file = new File("D:/test1.txt");
        //file.createNewFile(); // 비어있는 파일 생성
        File dir = new File("D:/fstudy"); // 지정된 경로를 찾을 수 없습니다 나옴
        File file = new File(dir, "test1.txt"); // 앞쪽이 보통 경로

        // exists() : 파일 또는 디렉토리 존재 유무
        if (!dir.exists()) { // 앞에 !는 디렉토리가 없는 경우
            dir.mkdir(); // 디렉토리 1개만 생성 -> fstudy 생성
        }

        file.createNewFile();
    }
}
