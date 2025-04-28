package solid.srp;

public class PaymentService {

    public void processPayment(String paymentInfo) {
        validatePaymentInfo(paymentInfo);
        System.out.println("Processing payment: " + paymentInfo);
    }

    private void validatePaymentInfo(String paymentInfo) {
        if (paymentInfo == null || paymentInfo.isEmpty()) {
            throw new IllegalArgumentException("Invalid payment information");
        }
        System.out.println("Validating payment information: " + paymentInfo);
    }
}
