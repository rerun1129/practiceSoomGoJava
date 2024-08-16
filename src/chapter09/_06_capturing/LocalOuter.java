package chapter09._06_capturing;

public class LocalOuter {
    /**
     * 클래스 변수: 프로그램 종료 까지, 가장 길다(메서드 영역)
     *      클래스 변수(static 변수)는 메서드 영역에 존재하고, 자바가 클래스 정보를 읽어 들이는 순간부터 프로그램
     *      종료까지 존재한다.
     * 인스턴스 변수: 인스턴스의 생존 기간(힙 영역)
     *      인스턴스 변수는 본인이 소속된 인스턴스가 GC 되기 전까지 존재한다. 생존 주기가 긴 편이다.
     * 지역 변수: 메서드 호출이 끝나면 사라짐(스택 영역)
     *      지역 변수는 스택 영역의 스택 프레임 안에 존재한다. 따라서 메서드가 호출 되면 생성되고, 메서드 호출이
     *      종료되면 스택 프레임이 제거되면서 그 안에 있는 지역 변수도 모두 제거된다. 생존 주기가 아주 짧다. 참고
     *      로 매개변수도 지역 변수의 한 종류이다.
     * */

    private int outInstanceVar = 3;
    public Printer process(int paramVar) {
        int localVar = 1; //지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.
        class LocalPrinter implements Printer {
            int value = 0;
            @Override
            public void print() {
                System.out.println("value=" + value);
                //인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("localVar=" + localVar);
                System.out.println("paramVar=" + paramVar);
                System.out.println("outInstanceVar=" + outInstanceVar);
            }
        }
        Printer printer = new LocalPrinter();
        //printer.print()를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.
        // 만약 localVar의 값을 변경한다면? 다시 캡처해야 하나??
        // localVar = 10; // print 메서드에서 컴파일 오류
        // paramVar = 20; // print 메서드에서 컴파일 오류
        return printer;
    }
    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        Printer printer = localOuter.process(2);
        //printer.print()를 나중에 실행한다. process()의 스택 프레임이 사라진 이후에 실행
        printer.print();
    }
}
