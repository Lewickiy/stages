package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "personage",
        uniqueConstraints = {
            @UniqueConstraint(
                name = "personage_id_unique",
                columnNames = "personage_id"
            )
        }
)
public class Personage {
    @Id
    @Column(name = "personage_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personage_id_generator"
    )
    @SequenceGenerator(
            name = "personage_id_generator",
            sequenceName = "personage_sequence_id",
            allocationSize = 1
    )
    private Integer id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @ManyToOne(cascade = CascadeType.ALL) //TODO Подумать пока не поздно. Каждый персонаж относится только к одному произведению. А как же вселенная Marvel
    @JoinColumn(name = "creative_work_id", insertable=false, updatable=false)
    private CreativeWork creativeWork;

    @ManyToOne(cascade = CascadeType.ALL) //Каждый персонаж может иметь только один пол
    @JoinColumn(name = "sex_id", insertable=false, updatable=false)
    private Sex sex;

    @ManyToOne(cascade = CascadeType.ALL) //Каждый персонаж может иметь только одну спецификацию
    @JoinColumn(name = "specification_id", insertable=false, updatable=false)
    private Specification specification;

}
