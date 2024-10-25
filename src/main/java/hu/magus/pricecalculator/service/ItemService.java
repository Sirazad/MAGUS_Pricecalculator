package hu.magus.pricecalculator.service;

import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems() {
        List<Item> response = repository.findAll();
        return response;
    }

    public Item getItemById(long id) {
        return repository.findById(id).orElse(null);
    }
}
