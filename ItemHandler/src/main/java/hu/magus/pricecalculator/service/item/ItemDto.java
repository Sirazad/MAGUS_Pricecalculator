package hu.magus.pricecalculator.service.item;


import hu.magus.pricecalculator.entity.Category;
import hu.magus.pricecalculator.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private String name;
    private int minPrice;
    private int maxPrice;
    private int quality;
    private Category category;
    private Material material;

}
