package chapter15._1enum.relate;

public class BeforeTableStatus {
    /**
     * 어떤 데이터베이스에서 Yes라는 의미와 No라는 의미를 쇼핑몰, 회계 처리, 기타 에서 각각 다른 데이터 타입으로 처리하는 경우가 있다.
     * 어떤 곳은 Yes를 "Y"로, 어떤 곳은 Yes를 1로, 어떤 곳은 Yes를 true로 처리한다.
     * 의미 상 틀리지는 않으나 이를 한 곳에서 처리하는 기능이 있다면 Yes를 하나의 논리로서 처리할 수 있는 로직들이 필요하다.
     * */
    public int getStatus1(String inputValue) {
        return inputValue.equals ( "Y" ) ? 1 : 0;
    }
    public boolean getStatus2(String inputValue) {
        return inputValue.equals ( "Y" );
    }
}
