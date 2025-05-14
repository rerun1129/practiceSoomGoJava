package solid.srp;

import static solid.srp.EncodeService.encodeForOrder;

public class OrderService {

    public void processOrder(String orderNo, String orderUser) {
        System.out.println("Order Number: " + orderNo);
        encodeForOrder(orderUser);
        System.out.println("Order User: " + orderUser);
        System.out.println("Order Completed");
    }
}
