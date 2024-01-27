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
@Table(name = "publicity")
public class PublicityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicity")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "user_create", length = 45, nullable = true)
    private String userCreate;

    @Column(name = "date_create", nullable = true)
    private Timestamp dateCreate;

    @Column(name = "user_modif", length = 45, nullable = true)
    private String userModif;

    @Column(name = "date_modif", nullable = true)
    private Timestamp dateModif;

    @Column(name = "user_del", length = 45, nullable = true)
    private String userDel;

    @Column(name = "date_del", nullable = true)
    private Timestamp dateDel;
}
