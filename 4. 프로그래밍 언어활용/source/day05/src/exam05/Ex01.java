package exam05;

public class Ex01 { // add 가 무엇을 수행할 지 모름 -> 추상 클래스 = 불완전 클래스 / 직접 선언 X
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator();
        int result = cal.add(10, 20);
        System.out.println(result);

        System.out.println(cal.num);
    } // 추상 클래스에서 다형성 사용 多
}
