package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int r = add(num1, num2); // 함수 이름 부르고 매개변수 설정 -> 함수 O | 실행될 때, 여기서 공간 할당 받음
        System.out.println(r);
    } // 위의 num1, num2 와 아래의 num1, num2 는 서로 다름

    public static int add(int num1, int num2) { // int num1, int num2 -> 변수 X | 변수 정의에 불과함 => 메모리 X
        int result = num1 + num2; // int result -> 변수 X | 변수 정의에 불과함 => 메모리 X

        return result; // 반환값 내보냄
    }
} // 반환값을 내보내고 나면 할 일이 끝났으므로 메모리에서 삭제함 | 스택 메모리 (실행할 때만 영역을 할당받음 = 연산에 필요한 공간 할당)
// 스택 = 함수 전용 메모리 영역