package exam02;

public abstract class Car {
    public abstract void start();
    public abstract void press();
    public abstract void turnoff();

    public final void run() { // 절차 정의 -> 템플릿 메서드 패턴 | 절차는 '자동차' 라면 동일, 구현 내용은 '자동차'마다 다름
        start();
        press();
        turnoff();
    } // 안에 내용 바뀌면 안됨 -> public 뒤에 final 붙임 | 재정의 불가!!
} // final = 상속 불가, 재정의 불가
