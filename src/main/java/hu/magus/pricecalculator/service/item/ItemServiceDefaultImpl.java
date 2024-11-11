package hu.magus.pricecalculator.service.item;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import hu.magus.pricecalculator.controller.item.UpdateItemRequest;
import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.exception.NoItemFoundException;
import hu.magus.pricecalculator.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemServiceDefaultImpl implements ItemService {
    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> getAllItems() {
        List<Item> response = repository.findAll();
        return response;
    }

    @Override
    public Item getItemById(long id) {
        return repository.findById(id).orElseThrow(() -> new NoItemFoundException("no item found for id " + id));
    }

    @Override
    public Item getItemByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new NoItemFoundException("no item found for id " + name));
    }

    @Override
    public List<Item> getItemsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Item> getItemsByCategory(long categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public Item addItem(int id, AddItemRequest request) {

        return null;
    }

    @Override
    public Item modifyItem(int id, UpdateItemRequest request) {
        return null;
    }

    @Override
    public Item createItemForCategory(AddItemRequest request) {

        return null;
    }

//    public Item createItemForCategory(int id, Item item) {
//        if (Objects.nonNull(repository.findByName(item.getName()))) {
//            log.info("Item with this name already exists: {}", item.getName());
//            throw new IllegalArgumentException("Item already exists");
//        }
//
//        repository.save()
//    }
}
