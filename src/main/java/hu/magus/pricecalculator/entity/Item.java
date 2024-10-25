package hu.magus.pricecalculator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;
    public String name;
    @Column(name = "min_price")
    public int minPrice;
    @Column(name = "max_price")
    public int maxPrice;
    @Column(columnDefinition = "int default 25")
    int quality;
}
