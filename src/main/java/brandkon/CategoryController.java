package brandkon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //카테고리 목록 조회
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
