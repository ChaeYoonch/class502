package exam02;

public class A { // exam02.A
    public int numA; // public -> 모든 패키지 가능
    int numAA; // dafault 접근 제어자 | 같은 (동일) 패키지 에서만 접근 가능 | 그 외는 불가능

    private int numAAA;

    protected int numB;

    void printNum() {
        numAAA = 100;
        System.out.println(numAAA);
    }
} // 클래스 내부 -> { 중괄호 } 안 쪽
