package exam05;

public class Box<T> { // T = Type 자료형의 의미
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
