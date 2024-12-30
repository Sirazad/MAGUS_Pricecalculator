package hu.magus.pricecalculator.controller.item;


import lombok.Data;

@Data
public class AddItemRequest {

    private String name;
    private Integer minPrice;
    private Integer maxPrice;
    private int quality;
    private String categoryName;
    private String materialName;

}
