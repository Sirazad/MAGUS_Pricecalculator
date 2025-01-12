package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.service.category.CategoryService;
import hu.magus.pricecalculator.service.item.ItemDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ItemAddRequestToItemDtoConverterTest {

    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private ItemAddRequestToItemDtoConverter underTest;



    @Test
    @DisplayName("convert shouldThrowException when request is null")
    void convert_shouldThrowException_whenCategoryIsNull() {
        // GIVEN
        AddItemRequest request = AddItemRequest.builder()
                .categoryName(null)
                .name("item")
                .minPrice(1)
                .maxPrice(2)
                .materialName("wood")
                .build();
        NoCategoryFoundException expected = new NoCategoryFoundException("category is not provided");

        // WHEN
        NoCategoryFoundException actual = assertThrows(NoCategoryFoundException.class, () -> underTest.convert(request));

        // THEN
        assertEquals(expected.getMessage(), actual.getMessage());
        assertEquals(expected.getClass(), actual.getClass());
    }

    @Test
    @DisplayName("convert should return converted ItemDto when request is valid")
    void convert_shouldReturnConvertedItemDto_whenRequestIsValid() {
        // GIVEN
        AddItemRequest request = AddItemRequest.builder()
                .categoryName("category")
                .name("item")
                .minPrice(1)
                .maxPrice(2)
                .materialName("wood")
                .build();
        Category category = Category.builder()
                .name("category")
                .build();
        ItemDto expected = ItemDto.builder()
                .category(category)
                .name("item")
                .minPrice(1)
                .maxPrice(2)
                .build();

        // WHEN
        when(categoryService.getCategory(request.getCategoryName())).thenReturn(category);
        ItemDto actual = underTest.convert(request);

        // THEN
        assertEquals(expected, actual);
    }

}