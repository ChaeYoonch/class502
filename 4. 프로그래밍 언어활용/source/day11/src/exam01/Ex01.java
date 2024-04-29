package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); // Box<Apple>() 이지만 Apple 없어도 컴파일러가 뒤의 내용 판단 가능하므로 생략 O
        // 객체를 생성될 때, 자료형 결정됨
        appleBox.setItem(new Apple());
        // appleBox.setItem(new Grape()); Apple 로 명확하게 한정하였기에 다른 형태 허용하지 않음으로서 타입 안정성 확보

        Apple apple = appleBox.getItem(); // 형변환 하지 않고 바로 가져옴
        System.out.println(appleBox); // appleBox.toString();
    } // Box.java 의 T item 이 Ex01.java 의 Apple => X | T = Object why? Apple 일지 Grape 일지 모르기 때문에
}
