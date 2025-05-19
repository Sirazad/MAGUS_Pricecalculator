package hu.magus.pricecalculator.controller.category;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.service.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
@AllArgsConstructor
public class CategoryController {

    private CategoryService service;

    @PostMapping("/add")
    public ResponseEntity<String> createCategory(@RequestParam("name") @NonNull String name) {
        log.info("creating categories with {}", name);
        
        boolean result = service.createCategory(name);

        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Category created: " + name);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Category is either already exists or invalid");
        }
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }


    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id") Long id) {
        return service.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return service.getCategory(id);
    }

    @GetMapping
    public Category getCategory(@RequestParam("name") String name) {
        return service.getCategory(name);
    }
}
