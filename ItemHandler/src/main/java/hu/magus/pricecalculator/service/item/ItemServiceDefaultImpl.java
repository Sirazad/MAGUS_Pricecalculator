package hu.magus.pricecalculator.service.item;

import hu.magus.pricecalculator.controller.item.UpdateItemRequest;
import hu.magus.pricecalculator.entity.Item;
import hu.magus.pricecalculator.exception.NoItemFoundException;
import hu.magus.pricecalculator.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceDefaultImpl implements ItemService {

    private final ItemRepository repository;
    private final ConversionService converter;

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
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
    public Item addItem(ItemDto request) {

        if (repository.findByName(request.getName()).isPresent()) {
            log.info("Item with this name already exists: {}", request.getName());
            throw new IllegalArgumentException("Item already exists");
        }
        return repository.save(Objects.requireNonNull(converter.convert(request, Item.class)));
    }

    @Override
    public Item modifyItem(long id, UpdateItemRequest request) {
        return null;
    }

    @Override
    public boolean deleteItem(long id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> {
                    throw new NoItemFoundException(String.valueOf(id));
                });

        return repository.findById(id)
                .isEmpty();
    }


}
