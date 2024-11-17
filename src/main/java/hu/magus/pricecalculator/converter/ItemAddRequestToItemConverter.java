package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.service.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemAddRequestToItemConverter implements Converter<AddItemRequest, Item> {
    private final CategoryService categoryService;

    @Override
    public Item convert(AddItemRequest from) {
        Category category = categoryService.getCategory(from.getCategoryName());
        if (category == null) throw new NoCategoryFoundException(from.getCategoryName());

        // TODO check material


        Item newItem = new Item();
        newItem.setCategory(category);
        newItem.setName(from.getName());
        newItem.setQuality(from.getQuality());
        newItem.setMinPrice(from.getMinPrice());
        newItem.setMaxPrice(from.getMaxPrice());
        // TODO add material to newItem
        newItem.setMaterial(null);


        return newItem;
    }

}
