package hu.magus.pricecalculator.service.category;

import hu.magus.pricecalculator.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategory(String name);

    Category getCategory(Long id);

    boolean createCategory(String name);
}
