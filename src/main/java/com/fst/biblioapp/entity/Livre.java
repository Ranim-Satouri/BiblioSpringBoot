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
@Table(name = "Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long coteLivre;
    @Column
    private String titre;
    @Column
    private String auteur;
    @Column
    private String editeur;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "idFour")
    private Fournisseur fournisseur;

    //@OneToMany(mappedBy = "livre", cascade = CascadeType.REMOVE)
    //private List<Emprunt> livre;
}

