package exam01;

import java.lang.reflect.Method;

public class Ex05 {
    public static void main(String[] args) {
        Class cls = Student.class;  // 정적 객체 -> 정보성 객체

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
