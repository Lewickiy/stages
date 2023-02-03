package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "performance",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "performance_id_unique",
                        columnNames = "performance_id"
                )
        }
        )
public class Performance {
    @Id
    @Column(name = "performance_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "performance_id_generator"
    )
    @SequenceGenerator(
            name = "performance_id_generator",
            sequenceName = "performance_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "genre_id",
            nullable = false
    )
    private Genre genre;

    @Column(
            name = "descriptiom",
            unique = true,
            columnDefinition = "TEXT"
    )
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "premiere_date")
    private Date premiereDate;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
            name = "performance_id"
    )
    )
    private Set<Personage> personages;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "performance_id"
            )
    )
    private Set<Theatre> theatres;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "performance_id"
            )
    )
    private Set<CreativeWork> creativeWorks;
}
