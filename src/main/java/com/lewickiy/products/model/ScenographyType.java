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
@ToString
@Table(
        name = "scenography_type",
        uniqueConstraints = @UniqueConstraint(
                name = "scenography_type_id_unique",
                columnNames = "scenography_type_id"
        )
)
public class ScenographyType {
    @Id
    @Column(name = "scenography_type_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "scenography_type_id_generator"
    )
    @SequenceGenerator(
            name = "scenography_type_id_generator",
            sequenceName = "scenography_type_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "created_name")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;
}
