package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.service.category.CategoryService;
import hu.magus.pricecalculator.service.item.ItemDto;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemAddRequestToItemDtoConverter implements Converter<AddItemRequest, ItemDto> {
    private final CategoryService categoryService;

    @Override
    public ItemDto convert(AddItemRequest from) {
        Category category = categoryService.getCategory(from.getCategoryName());
        if (category == null) throw new NoCategoryFoundException(from.getCategoryName());

        // TODO check material


        ItemDto newItemDto = new ItemDto();
        newItemDto.setCategory(category);
        newItemDto.setName(from.getName());
        newItemDto.setQuality(from.getQuality());
        newItemDto.setMinPrice(from.getMinPrice());
        newItemDto.setMaxPrice(from.getMaxPrice());
        newItemDto.setMaterial(null);


        return newItemDto;
    }

}
