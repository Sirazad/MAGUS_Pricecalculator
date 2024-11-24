package hu.magus.pricecalculator.controller.material;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class GetMaterialsForCategoryRequest {

    @NotBlank
    @Size(min = 1, message = "Permitted categories are: I, II, III, MAGIC")
    String categoryName;
}
