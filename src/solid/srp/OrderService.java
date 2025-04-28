package solid.srp;

public class OrderService {

    public void processOrder(String orderNo, String orderUser) {
        System.out.println("Order Number: " + orderNo);
        encodeForOrder(orderUser);
        System.out.println("Order User: " + orderUser);
        System.out.println("Order Completed");
    }

    private void encodeForOrder(String orderUser) {
        System.out.println("Encoding order user: " + orderUser);
    }
}
