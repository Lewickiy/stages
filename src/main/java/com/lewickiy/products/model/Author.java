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
public class Author extends Person {
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "author_id")
    )
    Set<CreativeWork> creativeWorks;
}
