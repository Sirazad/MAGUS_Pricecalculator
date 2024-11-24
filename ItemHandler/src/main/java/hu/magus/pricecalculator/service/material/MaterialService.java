package hu.magus.pricecalculator.service.material;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.entity.MaterialCategory;

import java.util.List;

public interface MaterialService {

    public List<Material> getAllMaterials();

    public List<Material> getAllMaterialsForCategory(MaterialCategory category);

    public List<Material> getAllMaterialsWithNameContaining(String name);

    public Material getMaterial(String name);

    public Material createMaterial(String name, MaterialCategory category);

    public Material updateMaterial(MaterialDto materialDto);

    public boolean deleteMaterial(MaterialDto materialDto);
}
