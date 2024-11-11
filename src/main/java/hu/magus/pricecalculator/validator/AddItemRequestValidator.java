package hu.magus.pricecalculator.validator;

import hu.magus.pricecalculator.controller.item.AddItemRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddItemRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AddItemRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "Item name is not specified.");
        ValidationUtils.rejectIfEmpty(errors, "categoryName", "Item category is not specified.");
        ValidationUtils.rejectIfEmpty(errors, "materialName", "Material category is not specified.");
        ValidationUtils.rejectIfEmpty(errors, "minPrice", "Minimum price is not specified.");
        ValidationUtils.rejectIfEmpty(errors, "maxPrice", "Maximum price is not specified.");

        AddItemRequest request = (AddItemRequest) target;
        if (request.minPrice()>request.maxPrice()) errors.reject("Minimum price is over maximum price.");
        if (request.minPrice() < 0) errors.rejectValue("minPrice", "Minimum price is negative.");
        if (request.maxPrice() < 0) errors.rejectValue("maxPrice", "Maximum price is negative.");
    }
}
