package brandkon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //브랜드 목록 조회
    @GetMapping("/brands")
    public List<BrandResponse> getAllBrands(@RequestParam(defaultValue = "0") long categoryId){
        if(categoryId==0){
            return brandService.getAllBrands();
        } else {
            return brandService.getAllBrandsByCategoryId(categoryId);
        }
    }

    //브랜드 상세 조회
    @GetMapping("/brands/{brandId}")
    public BrandResponse getOneBrand(@PathVariable long brandId){
        return brandService.getOneBrand(brandId);
    }
}
