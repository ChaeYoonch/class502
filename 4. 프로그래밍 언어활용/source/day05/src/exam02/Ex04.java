package exam02;

public class Ex04 {
    public static void main(String[] args) {
        A ad = new D(); // D 라는 객체 안에 A
        // 위의 A와 아래의 A는 서로 다른 객체
        A ac = new C(); // C 라는 객체 안에 B, 그런 B 안에 A 존재 => A = C로 유래된 객체

        // C c = (C)ad; C c = ad; 서로 다른 출처라서 불가능 | C c = (C)ad; 명시적 형변환하면 가능하지만, 객체 출처 다르기에 오류 발생

        if (ad instanceof C) {
            C c = (C) ad;
        } // ad 의 출처가 D 이므로 오류 발생

        // C cc = (C)ac; 같은 출처라도 명시적 형변환해야지만 안전하게 하위 클래스로 이동 가능

        if (ac instanceof C) {
            C cc = (C) ac;
            System.out.println(cc.numC);
        }
    }
}
