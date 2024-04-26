package exam03;

import java.lang.annotation.Annotation; // Annotation 목적 = 정보 전달 -> 대상이 있음!! 추가 정보는 설정을 통해 전달 = 추상 메서드
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        Class cls = Ex02.class; // Class 클래스 사용

        MyAnno anno = (MyAnno) cls.getAnnotation(MyAnno.class); // Annotation anno = cls.getAnnotation(MyAnno.class);
        int min = anno.min(); // 호출
        int max = anno.max(); // 호출
        System.out.printf("min=%d, max=%d%n", min, max);

        String[] names = anno.names();
        System.out.println(Arrays.toString(names));

        String value = anno.value();
        System.out.println(value);
    }
}