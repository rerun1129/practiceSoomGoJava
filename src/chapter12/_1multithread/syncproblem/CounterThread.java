package chapter12._1multithread.syncproblem;

public class CounterThread extends Thread {
    private final Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
