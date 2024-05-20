package exam01;

public class Ex08 {
    public static void main(String[] args) throws InterruptedException {
        Ex08_1 th1 = new Ex08_1("*");
        Ex08_1 th2 = new Ex08_1("**");
        Ex08_1 th3 = new Ex08_1("***");

        th1.start();
        th2.start();
        th3.start();

        Thread.sleep(2000);
        th1.suspend(); // 일시정지

        Thread.sleep(2000);
        th2.suspend(); // 일시정지

        Thread.sleep(3000);
        th1.stop(); // 완전 정지 = 종료
        th2.stop(); // 완전 정지 = 종료

        Thread.sleep(2000);
        th3.stop(); // 완전 정지 = 종료
    }
}

class Ex08_1 implements Runnable {

    private volatile boolean stopped = false; // 정지 상태 X
    private volatile boolean suspended = false; // 일시정지 상태 X

    private Thread th;

    public Ex08_1(String name) {
        th = new Thread(this, name); // this 가 Runnable 인터페이스 | name 은 쓰레드의 이름이 됨
    }

    @Override
    public void run() { // 바로 실행하고자 하는 것 = run() 메서드
        while(!stopped) { // 완전 정지 구현 =  true 가 되면 완전히 멈춤
            if(!suspended) { // 일시정지 상태 통제 = true 가 되면 잠시 멈추다가 다시 실행
                System.out.println(th.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    }

    public void start() {
        th.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
} // dead lock 가능성이 있으므로 start() {}, suspend() {}, resume() {}, stop() {} 직접 구현