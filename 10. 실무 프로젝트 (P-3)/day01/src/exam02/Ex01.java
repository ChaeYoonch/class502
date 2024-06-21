package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Member.class;

        Constructor constructors = clazz.getDeclaredConstructors()[0]; // 메서드 호출할 땐 객체가 1개 있어야 함
        Object obj = constructors.newInstance(); // 객체 생성

        Method[] methods = clazz.getDeclaredMethods(); // 전체 모든 메서드 볼 수 있음
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
