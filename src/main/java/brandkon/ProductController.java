package brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //상품 목록 조회
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(@RequestParam(defaultValue = "0") long brandId){
        if(brandId==0){
            return productService.getAllProducts();
        } else {
            return productService.getAllProductsByBrandId(brandId);
        }
    }

    //인기 상품 목록 조회
    @GetMapping("/products/popular")
    public List<ProductResponse> getPopularProducts(@RequestParam(defaultValue = "0") long categoryId,
                                                    @RequestParam(defaultValue = "0") long brandId){
        return productService.getPopularProducts(categoryId, brandId);
    }

    //상품 상세 조회
    @GetMapping("/products/{productId}")
    public ProductDetailResponse getProductDetail(@PathVariable long productId){
        return productService.getProductDetail(productId);
    }
}
