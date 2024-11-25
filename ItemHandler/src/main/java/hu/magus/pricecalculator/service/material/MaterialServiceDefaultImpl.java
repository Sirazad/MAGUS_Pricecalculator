package hu.magus.pricecalculator.service.material;


import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.entity.MaterialCategory;
import hu.magus.pricecalculator.exception.EntityAlreadyExistsException;
import hu.magus.pricecalculator.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MaterialServiceDefaultImpl implements MaterialService {

    private final MaterialRepository repository;

    @Override
    public List<Material> getAllMaterials() {
        return repository.findAll();
    }

    @Override
    public List<Material> getAllMaterialsForCategory(MaterialCategory category) {
        return repository.findAllByMaterialCategory(category);
    }

    @Override
    public List<Material> getAllMaterialsWithNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public Material getMaterial(String name) {
        return repository.findByName(name);
    }

    @Override
    public Material createMaterial(MaterialDto material) {
        if(repository.existsByName(material.getName())) {
            throw new EntityAlreadyExistsException("Material " + material.getName() + " already exists, can not be created");
        }

        Material newMaterial = new Material();
        newMaterial.setMaterialCategory(material.getMaterialCategory());
        newMaterial.setName(material.getName());
        return repository.save(newMaterial);
    }

    @Override
    public Material updateMaterial(MaterialDto materialDto) {
//        repository.save(materialDto);
        return null;
    }

    @Override
    public boolean deleteMaterial(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
