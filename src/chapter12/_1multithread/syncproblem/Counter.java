package chapter12._1multithread.syncproblem;

public class Counter {
    private int count = 0;

    // count 값을 증가시키는 메서드
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
