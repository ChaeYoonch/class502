package exam04;

import java.util.Vector;

public class Ex03 {
    public static void main(String[] args) {
        Vector<String> names= new Vector<>(3); // 3을 넘어서는 순간 2배씩 증가한 새로운 배열 생성
        System.out.println(names.capacity()); // 기본 10개 생성
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        System.out.println(names.capacity()); // 3
        names.add("이름4");
        System.out.println(names.capacity()); // 6 <- 2배로 증가
    }
}
