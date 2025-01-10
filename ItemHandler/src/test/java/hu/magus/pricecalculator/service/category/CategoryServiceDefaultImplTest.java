package hu.magus.pricecalculator.service.category;


import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceDefaultImplTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryServiceDefaultImpl underTest;

    @Test
    @DisplayName("given a valid, nonexisting category name, when createCategory is called, then return true")
    void testCreateCategory_shouldReturnTrue_whenCategoryIsSaved() {
        //GIVEN
        String name = "teszt kategória";
        Category newCategory = Category.builder().name(name).build();
        when(repository.findByName(name)).thenReturn(null).thenReturn(newCategory);
        when(repository.save(any())).thenReturn(newCategory);

        //WHEN
        boolean actual = underTest.createCategory(name);

        //THEN
        verify(repository, times(1)).save(newCategory);
        assertTrue(actual);
    }

    @Test
    @DisplayName("when saving a new category is unsuccessful, then return false")
    void testCreateCategory_shouldReturnFalse_whenEntityCreationFails() {
        //GIVEN
        String name = "";
        when(repository.findByName(name)).thenReturn(null);

        //WHEN
        boolean actual = underTest.createCategory(name);

        //THEN
        verify(repository, times(1)).save(any());
        assertFalse(actual);
    }

    @Test
    @DisplayName("given an existing category name, when createCategory is called, then return false")
    void testCreateCategory_shouldReturnFalse_whenCategoryAlreadyExists() {
        //GIVEN
        String name = "teszt kategória";
        when(repository.findByName(name)).thenReturn(new Category());

        //WHEN
        boolean actual = underTest.createCategory(name);

        //THEN
        verify(repository, times(0)).save(any());
        assertFalse(actual);
    }


}