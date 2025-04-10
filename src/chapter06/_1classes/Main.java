package chapter06._1classes;

public class Main {
    /**
     * 반드시 하나의 어플리케이션에는 하나의 main 함수가 존재해야 함.
     * */
    public static void main ( String[] args ) {
        /**
         * 스택에 변수로서 저장이 되며 이는 참조 타입이기 때문에 Heap 메모리 영역의 해당 번지에서 참조가 된다.
         * new의 의미를 잘 파악하고 있어야 함.
         * */
        Car car = new Car ( "흰색", 100, "아반떼", 200 );
        Car car2 = new Car ( "흰색", 100, "말리부", 200 );



        Person person = new Person ( car );
        person.machine.machineColor ();
    }
}

class PublicInnerClass {

}
