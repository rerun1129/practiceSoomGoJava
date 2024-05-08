package chapter06.accessmodifier.badencapsule;

import chapter06.accessmodifier.Membership;

import java.time.LocalDate;
import java.util.Date;

import static chapter06.accessmodifier.Membership.REGULAR;

public class Account {
    public Membership membership;
    public LocalDate expDate;
    public LocalDate serviceDate;

    public Account ( Membership membership, LocalDate expDate, LocalDate serviceDate ) {
        this.membership = membership;
        this.expDate = expDate;
        this.serviceDate = serviceDate;
    }

    public Membership getMembership ( ) {
        return membership;
    }

    public LocalDate getExpDate ( ) {
        return expDate;
    }

    public LocalDate getServiceDate ( ) {
        return serviceDate;
    }
}
