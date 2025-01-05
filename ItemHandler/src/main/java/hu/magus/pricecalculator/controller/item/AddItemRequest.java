package hu.magus.pricecalculator.controller.item;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddItemRequest {

    private String name;
    private Integer minPrice;
    private Integer maxPrice;
    private int quality;
    private String categoryName;
    private String materialName;

}
