package chapter06._4accessmodifier.badencapsule;

import static chapter06._4accessmodifier.Membership.GUEST;
import static chapter06._4accessmodifier.Membership.REGULAR;
import static java.time.LocalDate.now;

public class MemberService2 {

    public void validateGrade(){
        Account acc = new Account ( REGULAR, now (), now ( ) );
        if(acc.getMembership() == GUEST && acc.getExpDate().isAfter(now())){
            //손님인 경우에 따른 기능
        }
    }
}
