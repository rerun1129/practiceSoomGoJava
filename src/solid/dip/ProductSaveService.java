package solid.dip;

public class ProductSaveService {
    private final ProductSaveMybatisRepository productSaveRepository;

    public ProductSaveService(ProductSaveMybatisRepository productSaveRepository) {
        this.productSaveRepository = productSaveRepository;
    }

    public void saveProduct(Product product) {
        productSaveRepository.insertProduct(product);
    }
}
