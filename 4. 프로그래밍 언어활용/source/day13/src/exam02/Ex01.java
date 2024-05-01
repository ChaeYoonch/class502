package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3", "이름4", "이름5");
        names.forEach(s -> System.out.println(s)); // 람다식 = 1번만 쓰고 버리는 객체 = 메서드를 1개의 식으로 표현한 것
        /* names.forEach(new Consumer<String>() { // 함수형 프로그래밍에서 매개변수일 때 = 사용자 정의 기능
            // 함수 = 절차가 나열된 '실행 코드' -> 값으로 사용 X | 인터페이스가 객체가 되는 조건을 사용하여 비슷하게 흉내낼 수 O
            // 함수는 forEach 내부에서 실행 / 단일 기능 수행 -> 목적이 명확하게 1개만! | 그렇기에 짧게 쓸 수 있는 람다식 등장!
            @Override
            public void accept(String s) { System.out.println(s); } }); */
    }
}
