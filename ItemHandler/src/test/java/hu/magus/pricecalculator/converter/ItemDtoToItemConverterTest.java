package hu.magus.pricecalculator.converter;


import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.service.item.ItemDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemDtoToItemConverterTest {

    ItemDtoToItemConverter underTest = new ItemDtoToItemConverter();

    @Test
    @DisplayName("Given a valid ItemDto, when convert is called, then return a valid Item")
    void convert_shouldReturnValidItem_whenItemDtoIsValid() {
        //GIVEN
        Category category = Category.builder()
                .name("category")
                .build();
        Material material = Material.builder()
                .name("material")
                .build();
        ItemDto from = ItemDto.builder()
                .name("item")
                .minPrice(1)
                .maxPrice(2)
                .material(material)
                .category(category)
                .quality(2)
                .build();
        Item expected = Item.builder()
                .name("item")
                .minPrice(1)
                .maxPrice(2)
                .material(material)
                .category(category)
                .quality(2)
                .build();

        //WHEN
        Item actual = underTest.convert(from);

        //THEN
        assertEquals(expected, actual);
    }

}