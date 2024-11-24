package hu.magus.pricecalculator.controller.material;

import hu.magus.pricecalculator.entity.Material;
import hu.magus.pricecalculator.service.material.MaterialService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/material")
@AllArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @GetMapping("/all")
    public List<Material> getMaterials() {
        return service.getAllMaterials();
    }

}
