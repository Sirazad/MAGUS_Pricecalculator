package hu.magus.pricecalculator.converter;


import hu.magus.pricecalculator.controller.material.AddMaterialRequest;
import hu.magus.pricecalculator.entity.MaterialCategory;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import hu.magus.pricecalculator.service.material.MaterialDto;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MaterialAddRequestToMaterialDtoConverter implements Converter<AddMaterialRequest, MaterialDto> {

    @Override
    public MaterialDto convert(AddMaterialRequest from) {

        MaterialCategory materialCategory = null;
        try {
            materialCategory =  Enum.valueOf(MaterialCategory.class, from.materialCategory().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoCategoryFoundException("No such material category: " + from.materialCategory());
        }
        return MaterialDto.builder()
                .name(from.name())
                .materialCategory(materialCategory)
                .build();
    }
}
