package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Fournisseur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FournisseurService {
    List<Fournisseur> getfournisseurs();
    Fournisseur addFournisseur(Fournisseur fournisseur);
    ResponseEntity<?> updateFournissuer(Fournisseur fournisseur);
    ResponseEntity<String> deleteFournisseur(long idFour);
}
