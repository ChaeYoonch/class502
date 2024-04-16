package exam02;

public class Ex02 {
    public static void main(String[] args) {
        A a = new A();
        a.numAA = 10;
        a.printNum(); // a.numAAA 직접은 불가능 하지만, 둘러서는 가능
        a.numB = 100;
    }
}
