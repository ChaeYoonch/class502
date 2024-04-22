package exam13;

public class Ex01 {
    public static void main(String[] args) { // main 함수 내 = 지역 O
        Outer out = new Outer();
        Calculator cal = out.method(30); // 호출이 끝나도 값 30이 유지됨
        int result = cal.add(10, 20); // 30 + 10 + 20
        System.out.println(result);

        int result2 = cal.add(20, 30); // 30 + 20 + 30
        System.out.println(result2);
    }
}
