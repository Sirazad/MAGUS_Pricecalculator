package hu.magus.pricecalculator.service.material;

import hu.magus.pricecalculator.entity.MaterialCategory;
import lombok.Data;

@Data
public class MaterialDto {

    private Long id;
    private String name;
    private MaterialCategory materialCategory;
}
