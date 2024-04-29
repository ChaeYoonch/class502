package exam02;

import java.util.ArrayList;

public class Jucier {
    public static void make(FruitBox<?> box) {
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    } // 컴파일시 형식 다르면 컴파일러가 제거 (<Apple> 제거됨) | FruitBox box 만 남아 오류 발생
     // public static void make(FruitBox<Grape> box) { // (<Grape>가 제거됨) -> 메서드 중복정의 => 오류 발생}
}
