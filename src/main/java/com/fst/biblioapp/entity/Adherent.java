package com.fst.biblioapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Adherent")
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idAdherent;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String adresse;
    @Column
    private String telephone;

    //@OneToMany(mappedBy = "adherent", cascade = CascadeType.REMOVE)
    //private List<Emprunt> emprunt;
}

