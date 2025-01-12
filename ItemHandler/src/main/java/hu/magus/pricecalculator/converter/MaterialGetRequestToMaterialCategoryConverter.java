package hu.magus.pricecalculator.converter;

import hu.magus.pricecalculator.controller.material.GetMaterialsForCategoryRequest;
import hu.magus.pricecalculator.service.material.MaterialCategory;
import hu.magus.pricecalculator.exception.NoCategoryFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MaterialGetRequestToMaterialCategoryConverter implements Converter<GetMaterialsForCategoryRequest, MaterialCategory> {


    @Override
    public MaterialCategory convert(GetMaterialsForCategoryRequest from) {
        try {
            return Enum.valueOf(MaterialCategory.class, from.getCategoryName().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoCategoryFoundException("No such material category: " + from.getCategoryName());
        }
    }
}
