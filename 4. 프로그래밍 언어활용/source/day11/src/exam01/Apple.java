package exam01;

public class Apple extends Fruit implements Eatable { // 지네릭 타입 Fruit 과 Eatable 로 한정
    public String get() {
        return "사과"; // 단순히 "사과"라는 문자를 가져온다!
    } // get() 메서드 정의
}
