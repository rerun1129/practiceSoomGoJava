package solid.dip;

public class OrderSaveMybatisRepository {
    public void insertOrder(Order order) {
        System.out.println("Order saved using MyBatis: " + order);
    }
}
