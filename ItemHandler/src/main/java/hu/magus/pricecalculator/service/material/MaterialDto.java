package hu.magus.pricecalculator.service.material;

import hu.magus.pricecalculator.entity.MaterialCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialDto {

    private Long id;
    private String name;
    private MaterialCategory materialCategory;
}
