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
        name = "act",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "act_id_unique",
                        columnNames = "act_id"
                )
        }
        )
public class Act {
    @Id
    @Column(name = "act_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "act_id_generator"
    )
    @SequenceGenerator(
            name = "act_id_generator",
            sequenceName = "act_sequence_id",
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "descriptiom",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "act_id"
            )
    )
    private Set<Personage> personages;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "act_id"
            )
    )
    private Set<Department> departments;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "act_id"
            )
    )
    private Set<Employee> employees;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "act_id"
            )
    )
    private Set<Scenography> scenographySet;

}
