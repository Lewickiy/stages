package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "scenography",
        uniqueConstraints = @UniqueConstraint(
                name = "scenography_id_unique",
                columnNames = "scenography_id"
        )
)
public class Scenography {
    @Id
    @Column(name = "scenography_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "scenography_id_generator"
    )
    @SequenceGenerator(
            name = "scenography_id_generator",
            sequenceName = "scenography_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ManyToOne
    @JoinColumn(name = "scenography_type_id")
    private Scenography scenography;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(name = "weight")
    private Double weight;

    //TODO scenography_type

    @Column(name = "dimensions")
    private String dimensions;
    @Column(name = "date_of_manufacture")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfManufacture;

    @Column(name = "decommissioned")
    private Boolean decommissioned;
    @Column(name = "crated_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedType;
}
