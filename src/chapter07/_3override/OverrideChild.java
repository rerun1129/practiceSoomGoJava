package chapter07._3override;

public class OverrideChild extends OverrideParent {
    /**
     * 오버로딩의 정의 및 오버라이딩과의 간단한 차이
     * - 오버로딩 : 추가정의. 메서드 이름은 같지만 매개변수의 타입, 개수, 순서가 다른 메서드를 복수 정의하는 것.
     * - 오버라이딩 : 재정의. 부모 클래스의 메서드를 자식 클래스에서 덮어쓰는 것.
     *              - static, final, private : 키워드가 붙은 메서드는 오버라이딩 될 수 없다.
     *                 - static 은 클래스 레벨에서 작동하므로 인스턴스 레벨에서 사용하는 오버라이딩이 의미가 없다. 쉽게 이야기해서 그냥 클래스 이름을 통해 필요한 곳에 직접 접근하면 된다.
     *                 - final 메서드는 재정의를 금지한다.
     *                 - private 메서드는 해당 클래스에서만 접근 가능하기 때문에 하위 클래스에서 보이지 않는다. 따라서 오버라이딩 할 수 없다.
     *              - 생성자는 오버라이딩 할 수 없다.
     * */

    @Override
    public void somethingPrint ( String printString ) { //부모보다 넓게 사용할 수는 있다. 예외도 마찬가지로 부모보다 더 많이 Throw 할 수 없다.
        super.somethingPrint ( printString );
    }

//    @Override
//    private void somethingPrint ( String printString ) { //부모보다 좁게 사용할 수는 없다.
//        super.somethingPrint ( printString );
//    }

    public static void main ( String[] args ) {

    }
}
