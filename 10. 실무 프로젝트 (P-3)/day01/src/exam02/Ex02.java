package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Ex02 {
    public static void main(String[] args) throws Exception {
        Class clazz = Member.class;
        Constructor constructor = clazz.getDeclaredConstructors()[0];
        Object obj = constructor.newInstance();

        Field field = clazz.getDeclaredField("str"); // Field = 멤버 변수
        field.setAccessible(true);

        field.set(obj, "DEF");

        Member member = (Member) obj;
        System.out.println(member.str);
    }
}