package chapter08._1interface;


public interface Interfaces {
    /**
     * 인터페이스의 특징
     * 1. 멤버 변수 선언이 불가능 -> 대신 멤버 상수는 선언이 가능
     * 2. 추상 클래스와 동일하게 추상 메서드 선언가능. 단, abstract 예약어가 필요없음(생략됨)
     * 3. default 메서드라는 메서드가 있으며 추상 메서드의 내부 구현 메서드처럼 인터페이스 안에서 재정의할 수 있음(유일하게 default 접근 지시자가 사용되는 부분)
     * 4. static 메서드도 선언이 가능하며 default 메서드처럼 내부 구현이 필요함(디폴트 접근 지시자는 public)
     * 5. 상속과는 다르게 인터페이스는 다중 구현이 가능함.
     * */
//    String hi; //컴파일 에러 발생
    public final static String HI = "hi~"; //다른 접근 지시자는 선언이 불가능하고 public만 선언가능하며 디폴트로 public final static 이 선언되어 있음

    public abstract void greeting(); //기본적으로 외부에서 재정의를 반드시 해야하므로 public 접근 지시자만 사용가능하며 디폴트로 선언됨.

    default void realGreeting(){
        System.out.println ( "Hello!" );
    }

    static void staticGreeting() {
        System.out.println ( "Yey~!" );
    }
}
