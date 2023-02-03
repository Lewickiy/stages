package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "department",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "department_id_unique",
                        columnNames = "department_id"
                )
        }
        )
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_id_generator"
    )
    @SequenceGenerator(
            name = "department_id_generator",
            sequenceName = "department_sequence_id",
            allocationSize = 1
    )
    private Integer id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;
}
