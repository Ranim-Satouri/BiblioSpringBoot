package com.fst.biblioapp.repository;

import com.fst.biblioapp.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepo extends JpaRepository<Fournisseur,Long> {
}
