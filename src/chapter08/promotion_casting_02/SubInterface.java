package chapter08.promotion_casting_02;

public interface SubInterface extends ExtendableInterface1, ExtendableInterface2 {
    /**
     * 일반 클래스와는 다르게 인터페이스는 다중 상속이 가능하다.
     * 이는 일반 클래스가 실체성을 가지기 때문에 실체를 가진 클래스를 둘 이상 중복하여 재정의 한다면
     * 자칫 멤버 변수의 충돌 등 골치아픈 문제가 생기기 때문에 자바에서 막아두었지만
     * 인터페이스는 추상 메서드의 중복은 의미가 없고 멤버 변수는 애초에 선언이 불가능하니 default 및 static 메서드의 충돌만 막아두면 다중 상속이 큰 문제가 없다.
     * */

    @Override
    default void interfaceImplementable ( ){

    } //이렇게 구현 클래스까지 가지 않고 여기서 default 나 static 으로 미리 구현이 가능하다.

    //interfaceImplementableStatic 은 static 메서드이기 때문에 재정의가 불가능하다.
    //(또한 재정의할 필요가 없다. 메서드 영역의 메모리를 사용하므로 정의를 변경해야 한다면 위에서 하면 되기 때문에)



    @Override
    default void interfaceImplementableDefault ( ) {//default 메서드는 메서드 영역에 속하지 않으므로 재정의가 가능하다.
        ExtendableInterface2.super.interfaceImplementableDefault ( );
    }
}
