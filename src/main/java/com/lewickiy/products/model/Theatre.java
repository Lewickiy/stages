package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "theatre",
        uniqueConstraints = {
            @UniqueConstraint(
            name = "theatre_id_unique",
            columnNames = "theatre_id"
            )
        }
)
public class Theatre {
    @Id
    @Column(name = "theatre_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "theatre_id_generator"
    )
    @SequenceGenerator(
            name = "theatre_id_generator",
            sequenceName = "theatre_sequence_id",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "name",
            nullable = false,
            unique = true
    )
    private String name;
    @Column(name = "address")
    private String address;

    @Column(
            name = "website",
            unique = true
    )
    private String website;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BankDetails> bankDetails;
}
