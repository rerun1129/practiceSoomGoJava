package solid.dip;

public class OrderReadService {
    private final OrderReadMybatisRepository orderReadMybatisRepository;

    public OrderReadService(OrderReadMybatisRepository orderReadMybatisRepository) {
        this.orderReadMybatisRepository = orderReadMybatisRepository;
    }

    public Order responseOrderInformation(String orderId) {
        return orderReadMybatisRepository.findOrder(orderId);
    }
}
