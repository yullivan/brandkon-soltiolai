package brandkon;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    //브랜드 목록 조회
    public List<BrandResponse> getAllBrands(){
        List<BrandResponse> responses = brandRepository.findAll()
                .stream()
                .map(brand ->
                        new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl()))
                .toList();
        return responses;
    }

    public List<BrandResponse> getAllBrandsByCategorySlug(String categorySlug){
        List<BrandResponse> responses = brandRepository.findByCategorySlug(categorySlug)
                .stream()
                .map(brand -> new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl()))
                .toList();
        return responses;
    }

    //브랜드 상세 조회
    public BrandResponse getOneBrand(long id){
        Brand brand = brandRepository.findById(id)
                .orElseThrow();
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
