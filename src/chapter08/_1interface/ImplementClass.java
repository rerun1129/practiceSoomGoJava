package chapter08._1interface;

public class ImplementClass implements Implementable1, Implementable2{
    /**
     * 다중 구현이 가능하며 추상 메서드의 이름이 같다면 어차피 둘 다 구현을 해야 실제로 사용이 가능한 것이기에 컴파일 에러없이 둘 다 구현한 것으로 친다.
     * 다만, default 나  static 메서드는 메서드의 이름이 같다면 어떤 것을 사용할지 컴파일러가 결정할 수가 없기 때문에 구현 클래스에서
     * 이를 반드시 재구현 해줘야 한다.
     * */
    @Override
    public void needImpl ( ) {
        System.out.println ( "헤이!" );
    }

    @Override
    public void needNotImpl ( ) { // 이 메서드를 주석처리하면 컴파일 에러가 발생한다.
        Implementable1.super.needNotImpl ( );
    }

    @Override
    public void needImplOther ( ) {
        //각각의 인터페이스에 추상 메서드가 선언되어 있고 이를 모두 상속했다면 구현 클래스는 이를 모두 구현해야할 의무가 생긴다.
    }

    @Override
    public void needImplDiff ( ) {

    }

    public static void main ( String[] args ) {
        Implementable1 implementClass1 = new ImplementClass ( );
        Implementable2 implementClass2 = new ImplementClass ( );
        implementClass1.needImpl ();
        implementClass2.needImpl ();
    }
}
