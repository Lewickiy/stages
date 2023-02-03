package com.lewickiy.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "social_security_number")
public class SocialSecurityNumber { //TODO Поспорт. Добавить поля. Дата выдачи, где, кем, код подразделения.
    @Id
    @Column(
            name = "social_security_number_id",
            unique = true,
            nullable = false
    )
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
}
