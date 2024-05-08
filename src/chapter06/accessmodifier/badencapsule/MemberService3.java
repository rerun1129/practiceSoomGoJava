package chapter06.accessmodifier.badencapsule;

import static chapter06.accessmodifier.Membership.REGULAR;
import static chapter06.accessmodifier.Membership.SUPER;
import static java.time.LocalDate.now;

public class MemberService3 {

    public void validateGrade(){
        Account acc = new Account ( REGULAR, now (), now ( ) );
        if(acc.getMembership() == SUPER && acc.getExpDate().isAfter(now())){
            //슈퍼 회원인 경우에 따른 기능
        }
    }
}
