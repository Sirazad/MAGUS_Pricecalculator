package hu.magus.pricecalculator.repository;

import hu.magus.pricecalculator.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();

    List<Item> findByCategoryId(long categoryId);

    Optional<Item> findByName(String name);

    List<Item> findByNameContainingIgnoreCase(String name);
}
