package exam01;

public class Outer {

    private Calculator cal2 = new Calculator() {
        @Override
        public int add(int num1, int num2) {
            return num1 + num2;
        }
    };

    public Calculator method(int num3) {
        return /*Calculator cal = */ new Calculator() { // 익명 지역 변수
            public int add(int num1, int num2) {
                // num3 = 100; 지역변수의 상수화 final int num3 ...
                return num1 + num2 + num3;
            } // 지역 내에서 추상메서드 구현 -> 객체 생성
        };

        // return cal;
        /* int result = cal.add(10, 20);
        System.out.println(result); */
    }
}