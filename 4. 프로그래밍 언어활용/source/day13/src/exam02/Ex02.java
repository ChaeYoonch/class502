package exam02; // 람다 -> 함수형 프로그래밍이 꼭 나와야 함!!! | 사용자 정의 기능 -> 매개변수

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = (a, b) -> a + b;
        // 특수한 목적으로 생략시에는 -> 로 표시를 해주어야 함! | 한 줄인 경우 { 중괄호 } 생략 가능 | return 예약어 생략 가능!
        // 인터페이스의 정의를 보면 알 수 있기에 int 자료형 생략 가능 | num1,2 -> 변수명 => a,b 로 변경 | 최종으로 줄이면 위의 것

        /*  Calculator cal = (num1, num2) -> num1 + num2;
            아래 거 줄이면 위
            Calculator cal = (int num1, int num2) -> { return num1 + num2 };
            아래 거 줄이면 위
            Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        }; // 인터페이스 Calculator 가 객체가 됨 => 매개변수 (역할 한정적 -> 최대한 짧게 람다식 = 불필요한 것 모두 배제) */
    }
}
