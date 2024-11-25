package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Livre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LivreService {
    List<Livre> getLivres();
    ResponseEntity<?> addLivre(Livre livre ,Long idFour);
    ResponseEntity<?> updateLivre(Livre livre);
    ResponseEntity<String> deleteLivre(long idlivre);
}
