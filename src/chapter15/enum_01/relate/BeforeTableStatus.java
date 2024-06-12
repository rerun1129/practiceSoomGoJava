package chapter15.enum_01.relate;

public class BeforeTableStatus {
    public int getStatus1(String inputValue) {
        return inputValue.equals ( "Y" ) ? 1 : 0;
    }
    public boolean getStatus2(String inputValue) {
        return inputValue.equals ( "Y" );
    }
}
