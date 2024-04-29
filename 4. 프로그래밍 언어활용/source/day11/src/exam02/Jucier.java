package exam02;

import java.util.ArrayList;

public class Jucier {
    // ? -> Fruit, Apple, Grape 3개만 가능 | 상한 제한 = 위에서 아래로 Fruit 포함 아래
    public static void make(FruitBox<? extends Fruit> box) {
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    } // 컴파일시 형식 다르면 컴파일러가 제거 (<Apple> 제거됨) | FruitBox box 만 남아 오류 발생
     // public static void make(FruitBox<Grape> box) {(<Grape>가 제거됨) -> 메서드 중복정의 => 오류 발생}
    // 지네릭 메서드, extends 만 사용 가능
    public static <T extends Fruit> void make3(FruitBox<T> box) {

    }

    // ? -> Apple, Fruit, Object 3개만 가능 | 하한 제한 = 아래서 위로 Apple 포함 위
    public static void make2(FruitBox<? super Apple> box) {
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }
}
