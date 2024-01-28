package com.dev.ed.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "captures")
public class CapturesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capture")
    private Long id;

    @Column(name = "date_capture")
    private LocalDate dateCapture;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "id_seller", nullable = false)
    private SellersEntity sellersEntity;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "observation", length = 250, nullable = false)
    private String observation;

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
