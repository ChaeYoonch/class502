package exam03;

public class Box<T> { // 여기 T 는 객체 만들어질 때 결정

    private T item;  // 여기 T 는 객체 만들어질 때 결정

    // Box 가 객체가 될 때 T가 결정 - 지네릭 클래스의 T
    public void method1(T str1, T str2) { // 지네릭 클래스의 반환형

    }

    // 지네릭 메서드 - 호출 시의 T의 자료형이 결정, 지네릭 메서드의 T
    public <T> void method2(T str1, T str2) {

    }
}
