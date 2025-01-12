package hu.magus.pricecalculator.service.category;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        if(repository.findByName(name) != null) {
            log.info("Category already exists with name: {}", name);
            return false;
        }
        Category category = Category.builder()
                .name(name)
                .build();
        repository.save(category);
        return repository.findByName(name) != null;
    }

    @Override
    public boolean deleteCategory(Long id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> {throw new NoCategoryFoundException(String.valueOf(id));});
        return repository.findById(id)
                .isEmpty();
    }
}
