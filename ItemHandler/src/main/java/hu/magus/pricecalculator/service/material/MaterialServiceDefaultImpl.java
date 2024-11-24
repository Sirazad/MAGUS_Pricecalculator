package hu.magus.pricecalculator.service.material;


import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.entity.MaterialCategory;
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
        return List.of();
    }

    @Override
    public List<Material> getAllMaterialsWithNameContaining(String name) {
        return List.of();
    }

    @Override
    public Material getMaterial(String name) {
        return null;
    }

    @Override
    public Material createMaterial(String name, MaterialCategory category) {
        return null;
    }

    @Override
    public Material updateMaterial(MaterialDto materialDto) {
        return null;
    }

    @Override
    public boolean deleteMaterial(MaterialDto materialDto) {
        return false;
    }
}
