package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = {new Human(), new Bird(), new Tiger()}; // 선언과 동시에 초기화
        // Animal[] animals = new Animal[3];
        // animals[0] = new Human()
        // animals[1] = new Bird()
        // animals[2] = new Tiger() => 6~9번 줄을 요약한 것이 5번 줄 1문장!

        for (Animal animal : animals) {
            animal.move();

            if (animal instanceof Human) {
                Human human = (Human) animal; // 강제 형변환
                human.reading();
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                tiger.hunting();
            }

        }
    }
}
