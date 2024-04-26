package exam02;

public abstract class Transportation2 /* extends java.lang.Enum */ {
    public static final Transportation2 BUS = new Transportation2(){}; // 지역 내부 멤버 변수
    public static final Transportation2 SUBWAY = new Transportation2(){}; // 지역 내부 멤버 변수
    public static final Transportation2 TAXI = new Transportation2(){}; // 지역 내부 멤버 변수

    private Transportation2() {}

    //public abstract int getTotal(int person);
} // Enum 으로 상수만 열거 -> Enum 클래스의 객체가 생성되어 있음


