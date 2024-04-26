package exam04;

public class Box { // Object = 모든 객체의 상위 클래스
    private Object item;

    public Object getItem() {
        return item;
    } // Box 의 반환값 = Object

    public void setItem(Object item) {
        this.item = item;
    }
}
