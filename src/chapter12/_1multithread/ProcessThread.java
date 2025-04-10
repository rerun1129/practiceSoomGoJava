package chapter12._1multithread;

public class ProcessThread {
    /**
     * - 프로세스와 파일, 프로그램
     *    - 프로그래밍 언어로 만들어진 소스 코드는 2차 메모리에 파일의 형태로 저장이 된다.
     *    - 이 파일(.exe)을 실행시키면 1차 메모리인 RAM에 소스 코드가 실행 중인 형태로 올라가게 되는데
     *      이 상태를 프로세스라고 한다.
     *    - 2차 메모리에 있는 파일을 프로그램이라고도 하며 프로그램을 실행하면 프로세스가 되는 것으로 이해하면 좋다.
     *
     * - 프로세스
     *     - 가상 메모리를 사용하는 객체
     *     - 스레드가 이 프로세스에 속하여 동작함
     *     - 프로세스 간에는 서로의 메모리에 접근할 수가 없음(서로 접근이 가능하다면 A프로세스가 계산해둔 메모리 공간을 B프로세스가 오염시킬 수 있음)
     *     - 각 프로세스는 Process Control Block이라는 공간을 할당받아 그 공간에서 동작함
     *         - 1프로세스 : n스레드
     *         - 쓰레드는 프로세스 내부에서 TCB(Thread Control Block)를 할당받음
     *         - PCB에 Code text가 저장되어 있음
     *     - 수많은 프로세스들은 한정된 CPU 자원을 분할하여 사용하게 됨
     *         - 이러한 분할을 시분할이라고 하는데 이와같은 분할 작업의 스위칭은 CPU의 연산이 매우 빠르게 이루어지기 때문에 덩달아 빠르게 움직이며 한정된
     *           CPU 자원으로도 프로세스가 빠르게 동작한다
     *     - 프로그램의 실행 → 프로그램의 인스턴스 화 → 프로세스
     *
     * - 프로세스와 스레드의 관계
     *     - 실행 파일을 실행시키면 하나의 프로세스가 생성됨(exe 혹은 dll 등)
     *         - 그 프로세스 안에 스레드가 만들어짐
     *         - 이 스레드를 보통 메인 스레드라고 부름
     *     - 한 프로세스 안에 메인 스레드 이외에 다른 스레드가 있으면 멀티 스레드임
     *     - 하지만 스레드 간에 아무런 메모리 공유가 일어나지 않는다면 멀티 스레드라고 부르기 애매함
     *     - 프로세스와 스레드의 차이는 메모리 공유의 가능 여부로 판단한다
     *
     * */

    public static void main ( String[] args ) throws InterruptedException {
        //기본적인 스레드 사용
//        basicThread ( );
        //다른 스레드 기다리기
        threadJoin ();


    }

    private static void basicThread ( ) throws InterruptedException {
        Thread thread1 = new Thread ( ( ) -> System.out.println ( Thread.currentThread ().getName () ));
        Thread thread2 = new Thread ( ( ) -> System.out.println ( Thread.currentThread ().getName () ));
        Thread.sleep ( 1000 ); //1초 대기
        thread1.start ();
        thread2.start ();
    }

    private static void threadJoin ( ) throws InterruptedException {
        Thread thread1 = new Thread ( ( ) -> {
            System.out.println("thread1 시작됨.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("thread1 인터럽트됨.");
            }
            System.out.println("thread1 종료됨.");
        });
        Thread thread2 = new Thread ( ( ) -> {
            System.out.println("thread2 시작됨.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("thread2 인터럽트됨.");
            }
            System.out.println("thread2 종료됨.");
        });
        thread1.start ();
        thread2.start ();
        try {
            // t1이 완료될 때까지 기다림
            thread1.join();
            System.out.println("thread1 완료됨.");

            // t2가 완료될 때까지 기다림
            thread2.join();
            System.out.println("thread2 완료됨.");
        } catch (InterruptedException e) {
            System.out.println("메인 스레드 인터럽트됨.");
        }
        System.out.println("모든 스레드 완료됨.");
        //join이 없다면 메인 스레드가 먼저 완료되고 후에 각 스레드가 완료됨
        //join이 있으면 모든 스레드가 종료될때까지 다른 스레드를 기다리므로 main thread 완료 출력이 마지막에 출력됨.
    }
}
