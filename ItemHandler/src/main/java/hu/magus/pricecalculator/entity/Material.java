package hu.magus.pricecalculator.entity;

import hu.magus.pricecalculator.service.material.MaterialCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "materials")
@Data
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "material-category")
    private MaterialCategory materialCategory;

}
