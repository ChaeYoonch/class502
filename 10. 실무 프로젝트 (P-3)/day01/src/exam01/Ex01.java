package exam01;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Class clazz = JoinService.class;

        Constructor[] constructors = clazz.getDeclaredConstructors(); // 동적 객체 생성 - Reflection API
        for (Constructor constructor : constructors) {
            System.out.println("매개변수 갯수 : " + constructor.getParameterTypes().length);

            List<Object> arguments = new ArrayList<>();
            for (Class clz : constructor.getParameterTypes()) {
                if (clz == String.class) { // 문자열인 경우
                    arguments.add("문자열");
                } else if (clz == int.class) { // 기본 자료형 int 정수형인 경우
                    arguments.add(100);
                } else if (clz == long.class) { // 기본 자료형 long 인 경우
                    arguments.add(200L);
                }
            }

            Object obj = arguments.isEmpty()?constructor.newInstance():constructor.newInstance(arguments.toArray());
            // 비어 있으면 빈 값으로, 비어 있지 않으면 값 호출 | 동적으로 객체 생성
            JoinService service = (JoinService) obj; // (JoinService) 형 변환
            System.out.println(service); // 각 각 다른 주소가 나옴
        }

        /*
        Constructor c1 = constructors[0];
        Constructor c2 = constructors[1];
        Constructor c3 = constructors[1];

        JoinService s1 = (JoinService) c1.newInstance(); // JoinService 클래스의 public JoinService() {} 안에 정의된 값 나옴
        JoinService s2 = (JoinService) c2.newInstance("값1", 100); // 생성자가 매개변수 2개로 정해짐, 그 외는 오류 발생
        // JoinService 클래스의 public JoinService(String arg1, int arg2) {} 안에 정의된 값 나옴
        JoinService s3 = (JoinService) c3.newInstance(new Object[] {"값2", 200}); // 배열 객체 형태로 넣어도 가변적인 부분 동작 O
        */

        /*
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        */
    }
}