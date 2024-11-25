package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Emprunt;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> getEmprunts();
    ResponseEntity<?> addEmprunt(Emprunt emprunt , Long idLivre, Long idAdherent);
    Emprunt updateEmprunt(Emprunt emprunt);
    ResponseEntity<String> deleteEmprunt(long idEmp);
}
