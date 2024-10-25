package hu.magus.pricecalculator.controller;

import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

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

}
