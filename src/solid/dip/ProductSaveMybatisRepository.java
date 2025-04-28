package solid.dip;

public class ProductSaveMybatisRepository {
    public void insertProduct(Product product) {
        System.out.println("Inserting product with MyBatis: " + product);
    }
}
