package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Thread th = new Thread(new Ex02_1());
        th. start();

        for (int i = 0; i < 5; i++) {
            System.out.println("메인 쓰레드 - " + i);
        }
    }
}

class Ex02_1 implements Runnable { // 쓰레드 정의 X | Runnable 인터페이스만 정의한 것

    @Override
    public void run() { // run 인터페이스 구현체
        // 실행 중인 쓰레드 객체 = 위에 있는 th = new Thread
        Thread th = Thread.currentThread();

        for (int i = 0; i < 5; i++) {
            System.out.println(th.getName() + " - " + i);
        }
    }
}
