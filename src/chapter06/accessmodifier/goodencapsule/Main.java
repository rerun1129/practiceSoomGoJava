package chapter06.accessmodifier.goodencapsule;

public class Main {
    public static void main ( String[] args ) {
        MemberService1 memberService1 = new MemberService1 ( );
        MemberService2 memberService2 = new MemberService2 ( );
        MemberService3 memberService3 = new MemberService3 ( );
        MemberService4 memberService4 = new MemberService4 ( );
        MemberService5 memberService5 = new MemberService5 ( );

        memberService1.validateGrade ();
        memberService2.validateGrade ();
        memberService3.validateGrade ();
        memberService4.validateGrade ();
        memberService5.validateGrade ();
    }
}
