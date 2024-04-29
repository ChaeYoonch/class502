package exam02;

public class Ex03 {
    public static void main(String[] args) {
        FruitBox<Toy> toyBox = new FruitBox<>();
        toyBox.add(new Toy());
        Jucier.make(toyBox); // Apple, Grape, Fruit 만 가능하도록 상한 제한 사용하여서 오류 발생!
    }
}
