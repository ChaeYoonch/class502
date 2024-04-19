package exam02;

public class Ex03 {
    public static void main(String[] args) {
        C c = new C(); // instanceof = 출처 체크해볼 때 사용
        System.out.println(c instanceof C); // c가 C 클래스로부터 만들어진 것인지 물어보는 것 = true
        System.out.println(c instanceof B); // c가 C 클래스안의 B가 존재하는지 물어보는 것 = true
        System.out.println(c instanceof A); // 유래된 객체인지 체크해보는 것 = true

        // System.out.println(c instanceof String);
    }
}
