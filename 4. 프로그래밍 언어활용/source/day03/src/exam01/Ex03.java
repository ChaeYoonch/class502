package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule(2024, 3, 20);
        System.out.println(s1); // s1.toString(); -> 컴파일러가 자동 추가 | 멤버 변수의 값을 확인하는 용도로 재정의 | 16진수 방식
        /* System.out.println(System.identityHashCode(s1)); 객체의 주소값을 간결하게 표현 10진수 -> 16진수 | 10진수 방식 */
        System.out.println(s1.toString());
    }
}
