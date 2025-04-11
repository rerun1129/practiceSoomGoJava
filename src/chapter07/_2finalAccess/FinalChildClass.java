package chapter07._2finalAccess;

public class FinalChildClass /* extends FinalClass 컴파일 에러가 난다*/ extends FinalMethod {

    /**
     * final 키워드 정리
     * final 클래스는 상속을 받을 수 없다.
     * final 메서드는 재정의할 수 없다.
     * final 필드는 재할당할 수 없다.
     * */

//    @Override
//    public final void somethingPrint(){ //final 메서드는 자식 클래스에서 재정의할 수 없다.
//    }

}
