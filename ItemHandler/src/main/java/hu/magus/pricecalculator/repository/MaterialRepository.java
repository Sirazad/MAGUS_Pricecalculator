package hu.magus.pricecalculator.repository;

import hu.magus.pricecalculator.entity.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {


    public List<Material> findAll();
}
