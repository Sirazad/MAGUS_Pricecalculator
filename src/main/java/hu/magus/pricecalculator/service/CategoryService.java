package hu.magus.pricecalculator.service;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategory(String name) {
        return repository.findByName(name);
    }

    public Category getCategory(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        repository.save(category);
        return repository.findByName(name) != null;
    }
}
