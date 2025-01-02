package brandkon;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //상품 목록 조회
    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> responses = productRepository.findAll()
                .stream()
                .map(product ->
                        new ProductResponse(product.getId(), product.getBrand().getName() ,product.getName(), product.getPrice(),""))
                .toList();
        return responses;
    }

    public List<ProductResponse> getAllProductsByBrandId(long brandId){
        List<ProductResponse> responses = productRepository.findByBrandId(brandId)
                .stream()
                .map(product ->
                        new ProductResponse(product.getId(), product.getBrand().getName() ,product.getName(), product.getPrice(),""))
                .toList();
        return responses;
    }

    //인기 상품 목록 조회
    public List<ProductResponse> getPopularProducts(long categoryId, long brandId){
        List<Product> products;
        if(!(categoryId==0)) {
            products = productRepository.findByCategoryId(categoryId);
        } if (!(brandId==0)) {
            products = productRepository.findByBrandId(brandId);
        } else  {
            products = productRepository.findAll();
        }

        Collections.shuffle(products);

        List<Product> selectedProducts = products.stream()
                .limit(5) // 최대 5개
                .toList();

        return selectedProducts.stream()
                .map(product -> new ProductResponse(product.getId(), product.getBrand().getName(), product.getName(), product.getPrice(), ""))
                .toList();
    }

    //상품 상세 조회
    public ProductDetailResponse getProductDetail(long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow();
        Brand brand = product.getBrand();
        BrandSummary brandSummary = new BrandSummary(brand.getId(), brand.getName(), brand.getGuidelines());
        return new ProductDetailResponse(product.getId(), product.getName(), product.getPrice(), brandSummary, product.getExpirationDays());
    }
}
