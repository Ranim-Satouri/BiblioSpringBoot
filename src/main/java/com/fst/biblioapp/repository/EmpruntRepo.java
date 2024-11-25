package com.fst.biblioapp.repository;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Emprunt;
import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepo extends JpaRepository<Emprunt,Long> {
    List<Emprunt> findByAdherent(Adherent adherent);
    List<Emprunt> findByLivre(Livre livre);
}
