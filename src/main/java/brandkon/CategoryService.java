package brandkon;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //카테고리 목록 조회
    public List<CategoryResponse> getAllCategories(){
        List<CategoryResponse> responses =  categoryRepository.findAll()
                .stream()
                .map(category
                        -> new CategoryResponse(category.getId(), category.getName(), category.getSlug(), category.getImageUrl()))
                .toList();
        return responses;
    }
}
