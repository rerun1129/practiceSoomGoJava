package chapter07._3override;

public class OverrideChild extends OverrideParent {
    @Override
    public void somethingPrint ( String printString ) { //부모보다 넓게 사용할 수는 있다.
        super.somethingPrint ( printString );
    }

//    @Override
//    private void somethingPrint ( String printString ) { //부모보다 좁게 사용할 수는 없다.
//        super.somethingPrint ( printString );
//    }

    public static void main ( String[] args ) {

    }
}
