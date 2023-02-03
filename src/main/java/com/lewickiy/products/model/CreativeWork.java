package com.lewickiy.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "creative_work",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "creative_work_id_unique",
                        columnNames = "creative_work_id"
                )
        }
)
public class CreativeWork {
    @Id
    @Column(name = "creative_work_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "creative_work_id_generator"
    )
    @SequenceGenerator(
            name = "creative_work_id_generator",
            sequenceName = "creative_work_sequence_id",
            allocationSize = 1
    )
    private Integer id;
    @Column(
            name = "name",
            length = 128,
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "original_publication_date"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate originalPublicationDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date updatedDate;
}
