package exam02;

public class Ex02 {
    public static void main(String[] args) {
        FruitBox<Grape> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape());
        grapeBox.add(new Grape()); // 박스에 포도 총 2개 넣음

        Jucier.make(grapeBox); // 주스 제작 | 결과값 : [포도, 포도]
    }
}
