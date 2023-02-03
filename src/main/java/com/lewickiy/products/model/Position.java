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
        name = "position",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "position_id_unique",
                        columnNames = "position_id"
                )
        }
)
public class Position {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "position_id_generator"
    )
    @SequenceGenerator(
            name = "position_id_generator",
            sequenceName = "position_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            columnDefinition = "TEXT"
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
    @Column(name = "updated_date")
    private Date updatedDate;

    //TODO position many to many for Employee
}
