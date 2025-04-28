package solid.srp;

public class UserService {
    public void join(String userId, String password) {
        System.out.println("User joined with ID: " + userId);
        encodePassword(password);
        System.out.println("Password: " + password);
    }

    private void encodePassword(String password) {
        System.out.println("Encoding password: " + password);
    }
}
