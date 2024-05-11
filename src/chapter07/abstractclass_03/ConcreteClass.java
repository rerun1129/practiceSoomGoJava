package chapter07.abstractclass_03;

public class ConcreteClass extends AbstractClass{

    @Override
    protected void needImplement ( ) { //추상 클래스에서 abstract 로 선언된 메서드는 자식 클래스가 구현하지 않으면 컴파일 에러가 발생한다.
        //자식 클래스에는 어떤 메서드는 반드시 만들어야 한다는 강제성을 띄게 할 수 있기 때문에 어플리케이션이 초기 설계 의도대로 동작하게 이끌어갈 수 있고
        //개발자들이 어느 단위의 로직을 통일성 있게 구현할 수 있는 가이드 역할을 할 수 있다.
    }

    @Override
    void defaultMethod ( ) {
        super.defaultMethod ( ); //일반 메서드는 오버라이드해서 재정의해도 되고 그대로 사용해도 된다.
    }
}
