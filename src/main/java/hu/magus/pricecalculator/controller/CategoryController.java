package hu.magus.pricecalculator.controller;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/category")
    public boolean createCategory(@RequestParam("name") String name) {
        log.info("creating categories with {}", name);
        return service.createCategory(name);
    }

    @GetMapping("category")
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
}
