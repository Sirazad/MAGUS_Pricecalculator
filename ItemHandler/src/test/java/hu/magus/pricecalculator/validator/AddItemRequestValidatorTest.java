package hu.magus.pricecalculator.validator;


import hu.magus.pricecalculator.controller.item.AddItemRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddItemRequestValidatorTest {


    private AddItemRequestValidator underTest;
    private AutoCloseable resources;

    @BeforeEach
    void setUp() {
        underTest = new AddItemRequestValidator();
        resources = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        if(resources != null) resources.close();
    }

    @Test
    @DisplayName("Given a valid AddItemRequest, when validate is called, then no exception is thrown")
    void validate_shouldNotThrowException_whenRequestIsValid() {
        //GIVEN
        AddItemRequest request = new AddItemRequest();
        request.setName("name");
        request.setCategoryName("category");
        request.setMaterialName("material");
        request.setMinPrice(1);
        request.setMaxPrice(2);
        Errors errors = new BeanPropertyBindingResult(request, "addItemRequest");

        //WHEN
        underTest.validate(request, errors);

        //THEN
        assertEquals(0, errors.getErrorCount(), "One error should be present");
    }

    @Test
    @DisplayName("When fields are empty, errors are filled with the correct message")
    void validate_shouldAddError_whenFieldsIsEmpty() {
        //GIVEN
        AddItemRequest request = new AddItemRequest();
        Errors errors = new BeanPropertyBindingResult(request, "addItemRequest");

        //WHEN
        underTest.validate(request, errors);

        //THEN
        assertEquals(5, errors.getErrorCount(), "5 errors should be present");
        assertTrue(errors.hasFieldErrors("name"), "Error should be present for 'name'");
        assertTrue(errors.hasFieldErrors("categoryName"), "Error should be present for 'categoryName'");
        assertTrue(errors.hasFieldErrors("materialName"), "Error should be present for 'materialName'");
        assertTrue(errors.hasFieldErrors("minPrice"), "Error should be present for 'minPrice'");
        assertTrue(errors.hasFieldErrors("maxPrice"), "Error should be present for 'maxPrice'");

        assertEquals("Item name is not specified.", errors.getFieldError("name").getCode());
        assertEquals("Item category is not specified.", errors.getFieldError("categoryName").getCode());
        assertEquals("Material category is not specified.", errors.getFieldError("materialName").getCode());
        assertEquals("Minimum price is not specified.", errors.getFieldError("minPrice").getCode());
        assertEquals("Maximum price is not specified.", errors.getFieldError("maxPrice").getCode());
    }

    @Test
    @DisplayName("When minPrice is over maxPrice, errors are filled with the correct message")
    void validate_shouldAddError_whenMinPriceIsOverMaxPrice() {
        //GIVEN
        AddItemRequest request = new AddItemRequest();
        request.setName("name");
        request.setCategoryName("category");
        request.setMaterialName("material");
        request.setMinPrice(10);
        request.setMaxPrice(2);
        Errors errors = new BeanPropertyBindingResult(request, "addItemRequest");

        //WHEN
        underTest.validate(request, errors);

        //THEN
        assertEquals(1, errors.getErrorCount(), "One error should be present");
        assertTrue(errors.hasErrors(), "Error should be present");
        assertEquals("Minimum price is over maximum price.", errors.getGlobalError().getCode());
    }

    @Test
    @DisplayName("When minPrice and/or maxPrice is negative, errors are filled with the correct message")
    void validate_shouldAddError_whenPricesAreNegative() {
        //GIVEN
        AddItemRequest request = new AddItemRequest();
        request.setName("name");
        request.setCategoryName("category");
        request.setMaterialName("material");
        request.setMinPrice(-3);
        request.setMaxPrice(-2);
        Errors errors = new BeanPropertyBindingResult(request, "addItemRequest");

        //WHEN
        underTest.validate(request, errors);

        //THEN
        assertEquals(2, errors.getErrorCount(), "2 errors should be present");
        assertTrue(errors.hasErrors(), "Error should be present");
        assertEquals("Minimum price is negative.", errors.getFieldError("minPrice").getCode());
        assertEquals("Maximum price is negative.", errors.getFieldError("maxPrice").getCode());
    }
}