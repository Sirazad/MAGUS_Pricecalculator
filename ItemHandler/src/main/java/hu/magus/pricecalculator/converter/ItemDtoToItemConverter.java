package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.service.item.ItemDto;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemDtoToItemConverter implements Converter<ItemDto, Item> {

    @Override
    public Item convert(ItemDto from) {

        return Item.builder()
                .name(from.getName())
                .minPrice(from.getMinPrice())
                .maxPrice(from.getMaxPrice())
                .material(from.getMaterial())
                .category(from.getCategory())
                .quality(from.getQuality())
                .build();
    }
}
