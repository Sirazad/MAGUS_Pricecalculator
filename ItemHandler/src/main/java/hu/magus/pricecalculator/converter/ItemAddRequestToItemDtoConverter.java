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
        if (category == null) throw new NoCategoryFoundException("category is not provided");

        // TODO check material


        return ItemDto.builder()
                .name(from.getName())
                .minPrice(from.getMinPrice())
                .maxPrice(from.getMaxPrice())
                .quality(from.getQuality())
                .category(category)
                .material(null)
                .build();
    }

}
