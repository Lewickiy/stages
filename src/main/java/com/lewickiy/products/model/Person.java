package com.lewickiy.products.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "other_name")
    private String otherName;

    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @Column(
            name = "birthday",
            columnDefinition = "DATE"
    )
    private Date birthday;

    @Column(
            name = "date_of_death",
            columnDefinition = "DATE"
    )
    private Date dateOfDeath;

    @Column(
            name = "biography",
            columnDefinition = "TEXT"
    )
    private String biography;

    @Column(
            name = "phoneNo",
            columnDefinition = "BIGINT"
    )
    private Long phone;

    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;

    @Column(
            name = "address",
            columnDefinition = "TEXT"
    )
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tin_id", referencedColumnName = "tin_id")
    private Tin tin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "social_security_number_id", referencedColumnName = "social_security_number_id")
    private SocialSecurityNumber ssn;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Passport> passports;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(
                    name = "person_id"
            )
    )
    Set<BankDetails> bankDetailsList;
}
