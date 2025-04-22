package chapter08._1interface.movie.payment;

public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentInfra paymentInfra;

    public PaymentService(PaymentRepository paymentRepository, PaymentInfra paymentInfra) {
        this.paymentRepository = paymentRepository;
        this.paymentInfra = paymentInfra;
    }

    public void processPayment(Object request) {
        paymentInfra.processPayment();
        //요청 객체를 DB에서 요구하는 스펙에 맞게 조정
        Object insertRequest = request; // 변환 로직
        paymentRepository.insertPayment(insertRequest);
    }
}
