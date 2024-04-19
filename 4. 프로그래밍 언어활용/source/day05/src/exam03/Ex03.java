package exam03;

public class Ex03 {
    public static void main(String[] args) { // 가상 메서드 테이블 이용 예시
        Human human = new Human();
        human.move();

        Human human2 = new Human();
        human2.move();

        Human human3 = new Human();
        human3.move(); // human.move() = human2.move() = human3.move(); 참조 -> 찾을 수 있는 테이블 동일

        Animal animal = new Animal();
        animal.move();

        Tiger tiger = new Tiger();
        tiger.move();

        Bird bird = new Bird();
        bird.move();
    }
}
