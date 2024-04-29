package exam05;

public class Box<T> { // T = Type 자료형의 의미 | T = 타입 매개변수
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
