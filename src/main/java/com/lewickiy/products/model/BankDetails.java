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
        name = "bank_details",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "bank_details_unique",
                    columnNames = "bank_details_id"
            )
})

public class BankDetails {
    @Id
    @Column(name = "bank_details_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "bank_details_id_generator"
    )
    @SequenceGenerator(
            name = "bank_details_id_generator",
            sequenceName = "bank_details_sequence_id",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "legal_entity")
    private String legalEntity;
    @Column(name = "business_address")
    private String businessAddress;
    @Column(name = "postal_address")
    private String postalAddress;
    @Column(
            name = "bank_name",
            nullable = false
    )
    private String bankName;
    @Column(
            name = "tin",
            unique = true,
            nullable = false
    )
    private Long taxpayerIdentificationNumber;
    @Column(name = "trrc")
    private Long taxRegistrationReasonCode;
    @Column(name = "psrn")
    private Long primaryStateRegistrationNumber;
    @Column(
            name = "acc",
            nullable = false,
            unique = true
    )
    private Long acc;
    @Column(
            name = "corr_acc",
            nullable = false
    )
    private Long corrAcc;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
}
