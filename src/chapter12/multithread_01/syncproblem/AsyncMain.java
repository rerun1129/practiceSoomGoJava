package chapter12.multithread_01.syncproblem;

public class AsyncMain {
    /**
     * 이 예제에서는 Counter 클래스가 하나의 count 변수를 가지고 있고,
     * increment 메서드를 통해 이 변수를 증가시킴
     * 두 개의 스레드 CounterThread가 같은 Counter 객체를 공유하며 동시에 increment 메서드를 호출
     *
     * 각 스레드는 increment 메서드를 1000번 호출
     * 이론적으로는 두 스레드가 완료되면 count의 값이 2000이 되어야 하지만,
     * 동기화 문제가 발생하면 예상한 값보다 낮은 값이 출력될 수 있음
     * Ex) 1번 스레드 -> 10이 들어있는 count 변수를 가지고 count++를 하고 있음 => count = 11
     *     2번 스레드 -> 10이 들어있는 count 변수를 가지고 count++를 함 => count = 11
     *     [다음 동작] 1번 스레드 -> 11이 들어있는 count 변수를 가지고 count++
     *
     * 이 동기화 문제를 해결하려면 increment 메서드를 synchronized 키워드를 사용하여 동기화하면 됨
     * */
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종 카운트 값: " + counter.getCount());
    }
}
