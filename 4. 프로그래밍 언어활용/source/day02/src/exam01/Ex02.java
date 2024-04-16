package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int n1 = 10; // main 의 n1 | 스택 영역에서 할당 받음
        int n2 = 20;
        int r = add(n1, n2);
        // System.out.println(r);
    }
    static int add(int n1, int n2) { // int n1 & int n2 = 자료형 | 변수명은 같지만 서로 다름 | add 의 n1
        int result = n1 + n2;

        return result;
    } // return result => 반환값
}


