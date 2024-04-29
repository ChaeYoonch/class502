package exam01;
// T 를 특정 클래스의 하위클래스로 정의 -> T를  Fruit 의 하위 클래스 => 상속 이용하기 위해
public class Box<T extends Fruit> { // Box<T> : 지네릭 클래스 | T = 타입 매개변수, Box = 원시타입
    private T item; // T 는 바뀔 수 있는 자료형 | 값을 담을 수 있는 자료형

    // private static T item2; -> 사용 불가, 처음부터 공간을 할당받으므로 자료형이 명확해야 함

    // private staticT[] nums = new T [3]; -> 사용 불가, 배열에서 공간 생성을 위해서는 자료형이 명확해야 함

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    } // 값 조회

    public String toString() {
        // T == Fruit
        // item.get()
        return item.get();
    } // 컴파일시점에 Object 로 되어있음 -> 상속 (Fruit)을 통해 변경함
}
