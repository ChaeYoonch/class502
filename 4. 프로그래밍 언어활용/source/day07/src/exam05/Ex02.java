package exam05;

public class Ex02 {
    public static void main(String[] args) {
        Object[] humans = new Object[2];
        humans[0] = new Human();
        humans[1] = new Tiger(); // Object -> 다형성으로 사용 가능
    }
}
