package chapter15.enum_01.grouping;

import static chapter15.enum_01.grouping.PayType.TOSS;

public class Main {
    public static void main ( String[] args ) {
        AfterPayGroup byPayCode = AfterPayGroup.findByPayCode ( TOSS );
        String pushToss = AfterPayGroup.pushByPayCode ( TOSS );
        System.out.println ( byPayCode );
        System.out.println ( byPayCode.getTitle () );
        System.out.println ( pushToss );
    }
}
