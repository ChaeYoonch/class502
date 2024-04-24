package exam04;

import static java.lang.Math.*; // Math 함수 사용 시 정적 자원은 바로 import 가능

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(abs(-10)); // -10 -> 10 | Math.abs | 절대값 기능
        System.out.println(ceil(10.2)); // 11 | Math.ceil |소수점 첫째 자리에서 올림
        System.out.println(floor(10.2)); // 10 | Math.floor | 소수점 첫째 자리에서 버림
        System.out.println(round(10.5)); // 11 | Math.round | 소수점 첫째 자리에서 반올림
        System.out.println(pow(2, 4)); // 16 | Math.pow | 앞의 것의 뒤의 승 -> 2의 4승
        System.out.println(sqrt(9)); // 3 | Math.sqrt | 루트값 -> root 9 = 3
    }
}
