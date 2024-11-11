package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.service.item.ItemDto;
import org.springframework.core.convert.converter.Converter;


public class ItemAddRequestToItemDtoConverter implements Converter<AddItemRequest, ItemDto> {

    @Override
    public ItemDto convert(AddItemRequest from) {

        return null;
    }

}
