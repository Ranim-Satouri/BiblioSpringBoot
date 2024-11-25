package com.fst.biblioapp.repository;

import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepo extends JpaRepository<Livre,Long> {
    List<Livre> findByFournisseur(Fournisseur fournisseur);
}
