package chapter06.accessmodifier.badencapsule;

import static chapter06.accessmodifier.Membership.REGULAR;
import static chapter06.accessmodifier.Membership.TEMP;
import static java.time.LocalDate.now;

public class MemberService4 {

    public void validateGrade(){
        Account acc = new Account ( REGULAR, now (), now ( ) );
        if(acc.getMembership() == TEMP && acc.getExpDate().isAfter(now())){
            //임시 회원인 경우에 따른 기능
        }
    }
}
