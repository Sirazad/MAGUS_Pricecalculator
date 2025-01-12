package hu.magus.pricecalculator.controller.material;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMaterialsWithNameRequest {

    @NotBlank
    @Size(min = 2, message = "The search term should be at least 3 char long")
    private String name;
}

