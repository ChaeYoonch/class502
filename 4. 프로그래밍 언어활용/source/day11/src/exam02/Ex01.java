package exam02;

public class Ex01 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple()); // 사과를 박스에 담음
        appleBox.add(new Apple()); // 사과를 총 2개 박스에 담음

        Jucier.make(appleBox); // 주스를 만듦 -> 결과 : [사과, 사과]
    }
}
