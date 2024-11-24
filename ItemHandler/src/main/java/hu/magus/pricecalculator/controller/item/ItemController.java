package hu.magus.pricecalculator.controller.item;

import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.service.item.ItemDto;
import hu.magus.pricecalculator.service.item.ItemService;
import hu.magus.pricecalculator.validator.AddItemRequestValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final AddItemRequestValidator addItemRequestValidator;
    private final ConversionService converter;


    @InitBinder("addItemRequest")
    protected void initAddItemBinder(WebDataBinder binder) {
        binder.addValidators(addItemRequestValidator);
    }

    @GetMapping("/all")
    public List<Item> getItems() {
        val response =  itemService.getAllItems();
        log.info("response for all items is: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") int id) {
        val response = itemService.getItemById(id);
        log.info("response for single item is: {}", response);
        return response;
    }

    @GetMapping("/category")
    public List<Item> getItemByCategory(@RequestParam("categoryId") int id) {
        return itemService.getItemsByCategory(id);
    }

    @PostMapping("/add")
    public Item addItem(@Valid @RequestBody AddItemRequest addItemRequest) {
        return itemService.addItem(converter.convert(addItemRequest, ItemDto.class));
    }
}
