package hu.magus.pricecalculator.controller.category;

import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.service.category.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

     @Mock
     private CategoryService service;

     @InjectMocks
     private CategoryController controller;


     @Nested
     @DisplayName("createCategory method")
     class createCategoryTest {

         @Test
         @DisplayName("Given a valid category name, when createCategory is called, then return true")
         void testCreateCategory_shouldReturnTrue_whenCategoryIsSaved() {
             //GIVEN
             String name = "category1";
             when(service.createCategory(name)).thenReturn(true);

             //WHEN
             boolean result = controller.createCategory(name);

             //THEN
             assertTrue(result);
         }

         @Test
         @DisplayName("Given an invalid category name, when createCategory is called, then return false")
         void testCreateCategory_shouldReturnFalse_whenCategoryIsNotSaved() {
             //GIVEN
             String name = "";
             when(service.createCategory(name)).thenReturn(false);

             //WHEN
             boolean result = controller.createCategory(name);

             //THEN
             assertFalse(result);
         }
     }

     @Nested
     @DisplayName("getAllCategories method")
     class getAllCategoriesTest {

         @Test
         @DisplayName("Given no input, when getAllCategories is called, then return a list of Category objects")
         void testGetAllCategories() {
             //GIVEN
             Category category1 = new Category();
             category1.setName("category1");
             Category category2 = new Category();
             category2.setName("category2");

             List<Category> categories = Arrays.asList(category1, category2);
             when(service.getAllCategories()).thenReturn(categories);

             //WHEN
             List<Category> result = controller.getAllCategories();

             //THEN
             assertEquals(categories, result);
         }
     }
}