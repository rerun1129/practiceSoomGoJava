package solid.srp;

public class EncodeService {

    public String encode(String str) {
        // 트리밍 작업
        return str.replaceAll(" ", "%20");
    }

    public String decode(String str) {
        return str.replaceAll("%20", " ");
    }

    public static void encodeForStorage(String str) {
        // 트리밍 작업
        System.out.println("Encoding string for storage: " + str);
    }

    public static void encodePassword(String password) {
        // 트리밍 작업
        System.out.println("Encoding password: " + password);
    }

    public static void encodeForOrder(String orderUser) {
        // 트리밍 작업
        System.out.println("Encoding order user: " + orderUser);
    }
}
