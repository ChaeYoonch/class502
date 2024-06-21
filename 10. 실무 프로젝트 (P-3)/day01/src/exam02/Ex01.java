package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Member.class;

        Constructor constructors = clazz.getDeclaredConstructors()[0]; // 메서드 호출할 땐 객체가 1개 있어야 함
        Object obj = constructors.newInstance(); // 객체 생성

        Method[] methods = clazz.getDeclaredMethods(); // 전체 모든 메서드 볼 수 있음
        for (Method method : methods) {
            String name = method.getName();
            if (!name.startsWith("set")) { // set 으로 시작할 때만 값을 넣어줌
                continue;
            }

            Class clz = method.getParameterTypes()[0];
            Object arg = null;
            if (clz == String.class) { // setter 메서드의 매개변수가 문자열

            } else if (clz == LocalDateTime.class) { // setter 메서드의 매개변수가 LocalDateTime.now();
                arg = LocalDateTime.now();
            }

            method.invoke(obj, arg); // setter 메서드 호출
        }

        System.out.println(obj);
    }
}