package exam01;

public class Ex00 {
    public static void main(String[] args) { // main 메서드 = 모든 프로그램 시작점 = 메인 작업대 | + 호출 스택 = 쓰레드
        Runnable r = () -> { // 쓰레드 (1)
            for (int i = 0; i < 5; i++) {
                System.out.println("쓰레드2-" + i);

                for(long j = 0; j < 10000000000L; j++);
            }
        };

        //start(new Ex01_1());
        //start(r);
        // Ex01_1 th1 = new Ex01_1(); // 아래의 extends 뒤에 있는 Thread
        // Thread th2 = new Thread(r);

        // th1.run(); // 쓰레드 (2)
        // th2.run(); // 쓰레드 (3)
        // th1.start(); // 호출 스택 생성 + run() 메서드 실행 -> 독립적인 작업공간 생성
        // th2.start(); // 호출 스택 생성 + run() 메서드 실행 -> 독립적인 작업공간 생성

        System.out.println("작업 종료!"); // (1) - (2) - (3) 순서대로 수행됨

       /*  public static void start(Runnable runnable) {
            Thread th = new Thread(runnable);
            th.start();
        } */
    }
}

class Ex01_1 extends Thread {
    public void run() { // run 이 작업대
        for (int i = 0; i < 5; i++) {
            System.out.println("쓰레드1-" + i);

            for(long j = 0; j < 10000000000L; j++);
        }
    }
}