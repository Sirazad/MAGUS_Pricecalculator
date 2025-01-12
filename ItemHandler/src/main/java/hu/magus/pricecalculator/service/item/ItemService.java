package hu.magus.pricecalculator.service.item;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.controller.item.UpdateItemRequest;
import hu.magus.pricecalculator.entity.Item;
import jakarta.validation.Valid;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(long id);

    Item getItemByName(String name);

    List<Item> getItemsByName(String name);

    List<Item> getItemsByCategory(long categoryId);

    Item addItem(@Valid ItemDto request);

    Item modifyItem(long id, UpdateItemRequest request);

    boolean deleteItem(long id);

}
