package hu.magus.pricecalculator.controller.category;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.service.category.CategoryService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/add")
    public boolean createCategory(@RequestParam("name") @NonNull String name) {
        log.info("creating categories with {}", name);
        return service.createCategory(name);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
}
