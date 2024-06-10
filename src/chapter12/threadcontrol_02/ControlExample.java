package chapter12.threadcontrol_02;

public class ControlExample {
    public static void main(String[] args) {
        ControlledThread t1 = new ControlledThread();
        ControlledThread t2 = new ControlledThread();
        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        try {
            // 메인 스레드가 일정 시간 동안 잠자기
            Thread.sleep(3000);

            // 모든 스레드 깨우기
            synchronized (t1) {
                t1.notifyAll();
            }

            synchronized (t2) {
                t2.notifyAll();
            }

            // 일정 시간 동안 잠자기
            Thread.sleep(2000);

            // 모든 스레드 중단시키기
            t1.stopRunning();
            t2.stopRunning();

            // 스레드가 종료될 때까지 기다리기
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("모든 스레드 완료됨.");
    }
}

class ControlledThread extends Thread {
    private boolean running = true;

    public void run() {
        try {
            while (running) {
                System.out.println(getName() + " 실행 중.");

                // 일정 시간 동안 잠자기
                Thread.sleep(1000);

                synchronized (this) {
                    System.out.println(getName() + " 대기 중.");
                    wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " 인터럽트됨.");
        }
        System.out.println(getName() + " 종료됨.");
    }

    public void stopRunning() {
        running = false;
        this.interrupt();
    }
}
