package exam01;

import java.util.function.BiFunction;

public class Ex02 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> calc = (a, b) -> a + b; // 기본형 int 는 불가능 -> wrapper 클래스 Integer 사용
        int result = calc.apply(10, 20);
        System.out.println(result);

        /**
         * 1. 연산을 위해서 Integer -> int (언박싱) / 반환값 Integer 로 변환 (오토박싱) / int result 로 변환 (언박싱) => 성능저하
         * 연산은 그냥 기본형으로 하는 게 좋다! 객체 연산 불가, 언박싱 = Integer -> int 꺼냄 / 반환값 Integer -> 객체가 됨 = 오토박싱
         * 2. 자료형 반복 : Integer 반복
         */
    }
}
