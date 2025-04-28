package solid.dip;

public class ProductReadService {
    private final ProductReadMybatisRepository productReadMybatisRepository;

    public ProductReadService(ProductReadMybatisRepository productReadMybatisRepository) {
        this.productReadMybatisRepository = productReadMybatisRepository;
    }

    public Product responseProduct(String productId) {
        // Logic to read a product
        return productReadMybatisRepository.findProduct(productId);
    }
}
