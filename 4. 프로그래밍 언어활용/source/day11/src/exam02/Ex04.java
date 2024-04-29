package exam02;

public class Ex04 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());

        Jucier.make2(appleBox); // Apple, Fruit, Object 가능 | 결과 : [사과]

        // FruitBox<Grape> grapeBox = new FruitBox<Grape>(); // 하한 제한되어있어 Grape 는 현재 불가능
        FruitBox<Fruit> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape()); // Fruit fruit = new Grape(); 가능
        Jucier.make2(grapeBox);
    }
}
