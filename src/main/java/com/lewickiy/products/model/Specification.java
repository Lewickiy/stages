package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "specification",
        uniqueConstraints = {
            @UniqueConstraint(
                name = "specification_id_unique",
                columnNames = "specification_id"
            )
        }
)
public class Specification {
    @Id
    @Column(name = "specification_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specification_id_generator"
    )
    @SequenceGenerator(
            name = "specification_id_generator",
            sequenceName = "specification_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            unique = true,
            nullable = false,
            length = 45
    )
    private String name;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updatedDate;
}
