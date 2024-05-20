package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");

                for (long j = 0; j < 10000000L; j++);
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 300; i++) {
                System.out.print("=");

                for (long j = 0; j < 10000000L; j++);
            }
        };

        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);

        th1.setPriority(Thread.MAX_PRIORITY); // 10
        th2.setPriority(Thread.MIN_PRIORITY); // 1 | th1 이 th2 보다 많이 실행될 것!

        System.out.printf("th1 : %d, th2 : %d%n", th1.getPriority(), th2.getPriority());
        th1.start();
        th2.start();
    }
}
