package exam03;

public class Human extends Animal {
    @Override // 메서드 재정의
    public void move() {
        System.out.println("두발로 직립보행.");
    }
}
