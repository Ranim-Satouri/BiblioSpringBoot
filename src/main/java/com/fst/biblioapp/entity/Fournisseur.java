package com.fst.biblioapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idFour;
    @Column
    private String nomFour;
    @Column
    private String raisonSociale;
    @Column
    private String adrFour;
    @Column
    public String type;
}
