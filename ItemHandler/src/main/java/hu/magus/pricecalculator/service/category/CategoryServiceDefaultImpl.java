package hu.magus.pricecalculator.service.category;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceDefaultImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategory(String name) {
        return repository.findByName(name);
    }

    @Override
    public Category getCategory(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        repository.save(category);
        return repository.findByName(name) != null;
    }
}
