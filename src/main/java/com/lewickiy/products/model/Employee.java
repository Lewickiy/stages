package com.lewickiy.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Person {
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Specification> specifications;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "employee_id"
            )
    )
    private Set<Position> positions;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "employee_id"
            )
    )
    private Set<Department> departments;
}
