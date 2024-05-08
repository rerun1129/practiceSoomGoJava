package chapter06.accessmodifier.badencapsule;

import chapter06.accessmodifier.Membership;

import java.time.LocalDate;
import java.util.Date;

import static chapter06.accessmodifier.Membership.REGULAR;
import static java.time.LocalDate.now;

public class MemberService1 {

    public void validateGrade(){
        Account acc = new Account ( REGULAR, now (), now ( ) );
        if(acc.getMembership() == REGULAR && acc.getExpDate().isAfter(now())){
            //정회원인 경우에 따른 기능
        }
        //만약 acc.getServiceDate().isBefore(fiveYearAgo) 이 조건이 모든 등급 유효 심사에 들어가야 한다면?
    }
}
