package hu.magus.pricecalculator.repository;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.entity.MaterialCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {


    List<Material> findAll();

    List<Material> findAllByMaterialCategory(MaterialCategory materialCategory);

    List<Material> findByNameContaining(String name);

    Material findByName(String name);

    boolean existsByName(String name);
}

