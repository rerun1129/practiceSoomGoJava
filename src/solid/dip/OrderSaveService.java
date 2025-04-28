package solid.dip;

public class OrderSaveService {
    private final OrderSaveMybatisRepository orderSaveMybatisRepository;

    public OrderSaveService(OrderSaveMybatisRepository orderSaveMybatisRepository) {
        this.orderSaveMybatisRepository = orderSaveMybatisRepository;
    }

    public void saveOrder(Order order) {
        orderSaveMybatisRepository.insertOrder(order);
    }
}
