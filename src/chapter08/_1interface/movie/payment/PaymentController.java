package chapter08._1interface.movie.payment;

public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void requestPayment(Object request) {
        paymentService.processPayment(request);
    }
}
