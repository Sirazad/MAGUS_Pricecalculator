package hu.magus.pricecalculator.controller.item;

import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.service.item.ItemService;
import hu.magus.pricecalculator.validator.AddItemRequestValidator;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private AddItemRequestValidator addItemRequestValidator;

    @InitBinder("addItem")
    protected void initAddItemBinder(WebDataBinder binder) {
        binder.addValidators(addItemRequestValidator);
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        val response =  itemService.getAllItems();
        log.info("response for all items is: {}", response);
        return response;
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable("id") int id) {
        val response = itemService.getItemById(id);
        log.info("response for single item is: {}", response);
        return response;
    }

    @GetMapping("/item/category")
    public List<Item> getItemByCategory(@RequestParam("categoryId") int id) {
        return itemService.getItemsByCategory(id);
    }

    @PostMapping("/item/add")
    public Item addItem(@RequestParam("addItemRequest") @Valid AddItemRequest request) {
        return itemService.createItemForCategory(request);
    }

}
