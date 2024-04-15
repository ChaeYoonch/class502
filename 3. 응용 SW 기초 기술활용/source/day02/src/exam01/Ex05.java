package exam01;

public class Ex05 {
    public static void main(String[] args) {
        // int total = 0;
        // int num = 0;
        int total = 0, num = 0;  // 위의 2개 와 동일한 내용 | 한꺼번에 선언 가능 | < 초기값 >

        while(num <= 100) { // < 조건식 - 반복을 멈추는 조건 >
            total += num; // total = total = num; 와 동일한 내용
            num++; // num = num + 1 의 증감식 형태 | < 증감식 >
        }

        System.out.println("합계:" +total); // < > 필수 조건
    }
}
