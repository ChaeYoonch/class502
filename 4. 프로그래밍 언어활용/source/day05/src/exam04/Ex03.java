package exam04;

public class Ex03 {
    public static void main(String[] args) {
        A ad = new D(); // 자동 형변환 O

        A ac = new C();

        if(ad instanceof C) {
            C c = (C) ad; // C c = ad; 서로 다름 -> 문제 발생 가능성 O
            System.out.println(1);
        } // false -> 유입 X

        if (ac instanceof C) {
            C c = (C) ac;
            System.out.println(2);
        }
    }
}
