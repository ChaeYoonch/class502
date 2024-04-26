package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.setItem(new Apple()); // Apple = 다형성으로 Object 로 인해 담을 수 있음

        Apple apple = (Apple)appleBox.getItem(); // 명시적 형변환 | 형변환의 번거로움 -> 지네릭스 등장 이유 1
        System.out.println(apple.get());

        Box grapeBox = new Box();
        grapeBox.setItem(new Grape());

        if(grapeBox.getItem() instanceof Apple) { // 타입 안정성이 떨어지는 문제 -> 지네릭스 등장 이유 2
            Apple grape = (Apple) grapeBox.getItem();
            System.out.println(grape.get());
        }
    }
}
