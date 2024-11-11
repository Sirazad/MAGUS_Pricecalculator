package hu.magus.pricecalculator.controller.item;


public record AddItemRequest(String name, int minPrice, int maxPrice, int quality, String categoryName,
                             String materialName) {

}
