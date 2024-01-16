package com.dev.ed.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "lastname", length = 100)
    private String lastName;

    @Column(name = "telephone", length = 20)
    private String telePhone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "document", length = 20)
    private String document;

    @Column(name = "user_create", length = 45, nullable = true)
    private String userCreate;

    @Column(name = "date_create", nullable = true)
    private Timestamp dateCreate;

    @Column(name = "user_modif", length = 45, nullable = true)
    private String userModif;

    @Column(name = "date_modif", nullable = true)
    private Timestamp dateModif;
}
