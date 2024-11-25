package hu.magus.pricecalculator.service.material;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.entity.MaterialCategory;

import java.util.List;

public interface MaterialService {

    List<Material> getAllMaterials();

    List<Material> getAllMaterialsForCategory(MaterialCategory category);

    List<Material> getAllMaterialsWithNameContaining(String name);

    Material getMaterial(String name);

    Material createMaterial(MaterialDto material);

    Material updateMaterial(MaterialDto materialDto);

    boolean deleteMaterial(Long id);
}
