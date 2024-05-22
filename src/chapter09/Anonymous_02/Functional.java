package chapter09.Anonymous_02;

@FunctionalInterface
public interface Functional {
    /**
     * FunctionalInterface 는 한글로 풀어쓰면 함수형 인터페이스이며 C언어나 자바스크립트에서 사용되는 함수형들을 자바에서 유사하게 사용할 수 있도록
     * 클래스가 하나의 함수처럼 사용이 되도록 지원하는 어노테이션이다.
     * 특징
     * 1. 인터페이스이기 때문에 익명 인터페이스로 구현해서 처리할 수 있다.
     * 2. 반드시 하나의 추상 메서드를 가진다.
     *    그 이유는 하나의 클래스가 함수처럼 취급되기 위해서는 어떤 메서드를 반드시 구현해야 하는지 암묵적으로 알 수 있어야 하는데
     *    구현 대상인 추상 메서드가 둘 이상이 존재한다면 컴파일러가 어떤 메서드가 반드시 구현되어야 하는지 알 수 없기 때문이다.
     * 3. default 및 static 메서드는 허용한다.
     *    함수형 인터페이스의 목적은 인터페이스에서 지시하는 형태의 클래스-메서드를 함수화하여 사용할 수 있게 하는 것이기 때문에
     *    이미 메서드로서 사용할 수 있는 default 및 static 메서드는 몇 개가 있어도 그 존재가 함수형 인터페이스의 정의에 어긋나지 않는다.
     * */
    void func(String str); //구현 강제
    default void needNotImplFunc(){} //이미 구현됨
    static void needNotImplStaticFunc(){} //이미 구현됨
}
