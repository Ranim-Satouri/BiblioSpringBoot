package com.fst.biblioapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmprunt;
    @ManyToOne
    @JoinColumn(name = "idAdherent")
    private Adherent adherent;
    @ManyToOne
    @JoinColumn(name = "idLivre")
    private Livre livre;
    @Column
    private Timestamp dateEmprunt;
    @Column
    private Timestamp dataRetour;
}
