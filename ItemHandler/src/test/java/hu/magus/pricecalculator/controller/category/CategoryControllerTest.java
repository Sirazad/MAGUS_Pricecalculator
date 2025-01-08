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
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
             String name = "teszt kategória";
             ResponseEntity<String> expected = ResponseEntity.status(201).body("Category created: " + name);
             when(service.createCategory(name)).thenReturn(true);

             //WHEN
             ResponseEntity<String> actual = controller.createCategory(name);

             //THEN
             assertEquals(expected, actual);
         }

         @Test
         @DisplayName("Given an invalid category name, when createCategory is called, then return false")
         void testCreateCategory_shouldReturnFalse_whenCategoryIsNotSaved() {
             //GIVEN
             String name = "";
             ResponseEntity<String> expected = ResponseEntity.status(409).body("Category is either already exists or invalid");
             when(service.createCategory(name)).thenReturn(false);

             //WHEN
             ResponseEntity<String> actual = controller.createCategory(name);

             //THEN
             assertEquals(expected, actual);
         }

         @Test
         @DisplayName("given a name for an already existing category, return false")
         void testCreateCategory_shouldReturnFalse_whenCategoryAlreadyExists() {
             //GIVEN
             String name = "test category";
             ResponseEntity<String> expected = ResponseEntity.status(409).body("Category is either already exists or invalid");
             when(service.createCategory(name)).thenReturn(false);

             //WHEN
             ResponseEntity<String> actual = controller.createCategory(name);

             //THEN
             assertEquals(expected, actual);
         }

     }

     @Nested
     @DisplayName("getAllCategories method")
     class getAllCategoriesTest {

         @Test
         @DisplayName("Given no input, when getAllCategories is called, then return a list of Category objects")
         void testGetAllCategories() {
             //GIVEN
             Category category1 = Category.builder()
                     .name("category1")
                     .build();
             Category category2 = Category.builder()
                     .name("category2")
                     .build();

             List<Category> categories = Arrays.asList(category1, category2);
             when(service.getAllCategories()).thenReturn(categories);

             //WHEN
             List<Category> result = controller.getAllCategories();

             //THEN
             assertEquals(categories, result);
         }
     }
}