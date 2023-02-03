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
        name = "genre",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "genre_id_unique",
                        columnNames = "genre_id"
                )
        }
)
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_id_generator"
    )
    @SequenceGenerator(
            name = "genre_id_generator",
            sequenceName = "genre_sequence_id"
            , allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            length = 45,
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;
}
