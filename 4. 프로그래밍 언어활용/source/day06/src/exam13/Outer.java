package exam13;

public class Outer {
    public Calculator method(int num3) { // 지역 내부 | void -> Calculator 로 변경함! | num3 = 함수 안에 정의된 지역변수
        Calculator cal = new Calculator() { // 미구현된 메서드 -> 직접 구현 = { 중괄호 }
            public int add(int num1, int num2) { // 객체 -> 힙 영역에 존재 | 객체의 반환값 = Calculator cal -> cal 에 있음
                // num3 = 100; // final int num3 -> 지역 변수의 상수화 = 지역변수가 제거되지 않게 하기 위해 | final 자동 추가됨
                return num1 + num2 + num3;
            }
        };

       /* int result = cal.add(10, 20);
        System.out.println(result); */

        return cal; // 외부에서 자원 활용 가능하도록! | return 때 제거됨
    }
}
