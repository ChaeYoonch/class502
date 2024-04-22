package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator();
        // SimpleCalculator => Calculator : 다형성 | 공통 자료형에 Calculator 틀이 동일 | 변경 유연성 O
        int result = cal.add(10, 20);
        System.out.println(result);
        System.out.println(cal.num); // 멤버변수에 공간 할당받음
    } // 함수 -> 기능적 협동을 할 수 있기에 중요 | 내부적으로 객체가 되어 있음
}
