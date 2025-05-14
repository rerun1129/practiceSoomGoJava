package solid.srp;

import static solid.srp.EncodeService.encodePassword;

public class UserService {
    public void join(String userId, String password) {
        System.out.println("User joined with ID: " + userId);
        encodePassword(password);
        System.out.println("Password: " + password);
    }
}
