package hu.magus.pricecalculator.controller.item;


import lombok.Data;

@Data
public class AddItemRequest {

    private String name;
    private int minPrice;
    private int maxPrice;
    private int quality;
    private String categoryName;
    private String materialName;

}
