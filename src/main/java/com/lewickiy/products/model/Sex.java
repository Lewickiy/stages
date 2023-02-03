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
        name = "sex",
        uniqueConstraints = {
                @UniqueConstraint(
                name = "sex_id_unique",
                columnNames = "sex_id"
                )
        }
)
public class Sex {
    @Id
    @Column(name = "sex_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sex_id_generator"
    )
    @SequenceGenerator(
            name = "sex_id_generator",
            sequenceName = "sex_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            length = 30,
            nullable = false,
            unique = true
    )
    private String name;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
}
