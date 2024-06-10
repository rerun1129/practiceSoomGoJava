package chapter12.multithread_01.syncproblem;

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
