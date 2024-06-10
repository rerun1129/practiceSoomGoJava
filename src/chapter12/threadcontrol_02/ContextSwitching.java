package chapter12.threadcontrol_02;

public class ContextSwitching {
    /**
     *  - Context Switching이란?
     *     - CPU는 컴퓨터의 여러 프로세스에 있는 여러 스레드들을 돌아가면서 실행시켜준다
     *     - 프로세스나 스레드가 중단되었다가 다시 실행될 때 필요한 정보를 컨텍스트라고 한다
     *     - 현재 실행 중인 컨텍스트를 잠시 중단 및 저장하고 새로운 컨텍스트를 로딩 및 실행하는 것을 Context Switching이라고 한다.
     *     - Context Switching은 오버헤드를 동반한다.
     *     - 가장 중요한 것은 Context Switching이 일어나면 캐시가 초기화(Flush) 된다는 것이다.
     *     - 다른 코드를 수행해야 하니 캐시를 비우고 새로운 메모리를 캐싱한다.
     *     - Context Switching은 sleep, Lock, I/O 등 단순 read, write, 연산 외에 시스템 API가 호출되면 거의 발생한다.
    * */
    public static void main(String[] args) {
        ContextSwitchingThread t1 = new ContextSwitchingThread("Thread-1");
        ContextSwitchingThread t2 = new ContextSwitchingThread("Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("모든 스레드 완료됨.");
    }
}

class ContextSwitchingThread extends Thread {
    private final String threadName;

    ContextSwitchingThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " - " + i);
            try {
                // 잠시 쉬면서 다른 스레드에게 실행 기회를 줌
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}