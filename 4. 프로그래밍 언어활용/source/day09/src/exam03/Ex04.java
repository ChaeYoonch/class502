package exam03;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple, Irange, Mango, Melon, Apple";
        System.out.printf("indexOf Apple: %d%n", fruits.indexOf("Apple")); // 왼쪽 -> 오른쪽
        System.out.printf("lastIndexOf Apple: %d%n", fruits.lastIndexOf("Apple")); // 오른쪽 -> 왼쪽
        System.out.printf("indexOf Banana: %d%n", fruits.indexOf("Banana")); // 없는 경우 : -1 나옴
    }
}
