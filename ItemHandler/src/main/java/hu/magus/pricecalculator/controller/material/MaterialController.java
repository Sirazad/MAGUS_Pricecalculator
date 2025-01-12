package hu.magus.pricecalculator.controller.material;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.service.material.MaterialCategory;
import hu.magus.pricecalculator.service.material.MaterialDto;
import hu.magus.pricecalculator.service.material.MaterialService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/material")
@AllArgsConstructor
public class MaterialController {

    private final MaterialService service;
    private final ConversionService converter;

    @GetMapping("/all")
    public List<Material> getMaterials() {
        return service.getAllMaterials();
    }

    @PostMapping("/category")
    public List<Material> getMaterialsForCategory(@Valid @RequestBody GetMaterialsForCategoryRequest request) {
        return service.getAllMaterialsForCategory(converter.convert(request, MaterialCategory.class));
    }

    @PostMapping
    public List<Material> getMaterialsWithName (@Valid @RequestBody GetMaterialsWithNameRequest request) {
        return service.getAllMaterialsWithNameContaining(request.getName());
    }

    @GetMapping
    public Material getMaterialByName(@NotBlank String name) {
        return service.getMaterial(name);
    }

    @PostMapping("/add")
    public Material createMaterial(@RequestBody AddMaterialRequest addMaterialRequest) {
        log.info("Creating material with name: {}", addMaterialRequest.name());
        log.info(addMaterialRequest.toString());
        return service.createMaterial(converter.convert(addMaterialRequest, MaterialDto.class));
    }
}
