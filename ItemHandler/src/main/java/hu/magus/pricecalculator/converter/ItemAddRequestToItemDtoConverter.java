package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.exception.NoMaterialFoundException;
import hu.magus.pricecalculator.service.category.CategoryService;
import hu.magus.pricecalculator.service.item.ItemDto;
import hu.magus.pricecalculator.service.material.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemAddRequestToItemDtoConverter implements Converter<AddItemRequest, ItemDto> {
    private final CategoryService categoryService;
    private final MaterialService materialService;

    @Override
    public ItemDto convert(AddItemRequest from) {
        Category category = categoryService.getCategory(from.getCategoryName());
        if (category == null) throw new NoCategoryFoundException("category is not provided");

        Material material = materialService.getMaterial(from.getMaterialName());
        if (material == null) throw new NoMaterialFoundException("material is not provided");

        return ItemDto.builder()
                .name(from.getName())
                .minPrice(from.getMinPrice())
                .maxPrice(from.getMaxPrice())
                .quality(from.getQuality())
                .category(category)
                .material(material)
                .build();
    }

}
