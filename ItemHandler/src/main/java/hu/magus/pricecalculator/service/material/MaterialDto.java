package hu.magus.pricecalculator.service.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDto {

    private Long id;
    private String name;
    private MaterialCategory materialCategory;
}
