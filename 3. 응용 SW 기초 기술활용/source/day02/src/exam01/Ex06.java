package exam01;

public class Ex06 {
    public static void main(String[] args) {
        int total = 0; // 원래 for(int i = 0, j = 10; i <= 100; i++, j +=2)
        int i = 0, j = 10;
        for (; ; i++, j += 2) { // ; -> 문장에서 그리고 의 의미 | () 안에 있던 내용 ;만 남기고 () 밖에 정의 가능
            if (i > 100) {
                break;
            }
            total += i;
            System.out.println("j:" +j);
        }

        System.out.println("합계:" + total);
    }

    // for ( ; ; ) { } == while(true) { ... }
}
