package hu.magus.pricecalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;
    public String name;

}
