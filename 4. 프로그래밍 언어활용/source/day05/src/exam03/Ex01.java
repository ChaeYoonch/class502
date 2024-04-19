package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Human human = new Human(); // Human, Animal
        // human.move();

        Tiger tiger = new Tiger(); // Tiger, Animal
        // tiger.move();

        Bird bird = new Bird(); // Bird, Animal
        // bird.move(); // move 동일한 메서드 반복 | Animal -> 공통 | 출처는 달라도 같은 자료형 O

        Animal[] animals = new Animal[3]; // Animal[] 대신 Human[] 을 사용할 경우 오류 발생 O | a = b; 의 경우 오른쪽이 본체!
        animals[0] = human; // Animal animals[0] = human 과 동일
        animals[1] = tiger; // Animal animals[1] = tiger
        animals[2] = bird; // Animal animals[2] = bird

        /* for (int i = 0; i < animals.length; i++) {
            animals[i].move();
        } */

        for (Animal animal : animals) { // 향상된 for 문
            animal.move();
        }
    }
}
