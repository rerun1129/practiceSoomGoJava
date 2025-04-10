package chapter12._2threadcontrol;

public class ContextSwitching {
    /**
     *  - Context Switching이란?
     *     - CPU는 컴퓨터의 여러 프로세스에 있는 여러 스레드들을 돌아가면서 실행시켜준다
     *     - 프로세스나 스레드가 중단되었다가 다시 실행될 때 필요한 정보를 컨텍스트(문맥)라고 한다
     *       Ex) A스레드 -> c = a + b -> 컨텍스트 스위칭 -> c = a + b까지의 실행 과정을 컨텍스트에 저장
     *           -> 다른 작업 -> 복귀(컨텍스트 스위칭) -> c = a + b를 진행하던 컨텍스트를 가지고 와서 하던 작업 수행
     *     - 현재 실행 중인 컨텍스트를 잠시 중단 및 저장하고 새로운 컨텍스트를 로딩 및 실행하는 것을 Context Switching이라고 한다.
     *     - Context Switching은 오버헤드를 동반한다.
     *        = 오버헤드
     *          - 오버헤드(overhead)는 어떤 처리를 하기 위해 들어가는 간접적인 처리 시간 및 메모리 등을 말한다.
     *          - 예를 들어 A라는 처리를 단순하게 실행한다면 10초 걸리는데, 안정성을 고려하고 부가적인 기능을 수행하는 B라는 처리를 추가한 결과
     *            처리시간이 15초 걸렸다면, 오버헤드는 5초가 된다.
     *            또한 이 처리 B를 개선해 B'라는 처리를 한 결과, 처리시간이 12초가 되었다면, 이 경우 오버헤드가 3초 단축되었다고 말한다
     *     - 가장 중요한 것은 Context Switching이 일어나면 캐시가 초기화(Flush) 된다는 것이다.
     *       - [뒤로 갈수록 CPU가 해당 저장공간에 접근할 수 있는 속도가 빨라지게 된다]
     *         2차 메모리(HDD, SSD) -> 1차 메모리(RAM) -> CPU캐시(L1, L2, L3) -> CPU레지스터
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