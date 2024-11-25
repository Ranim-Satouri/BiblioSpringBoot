package com.fst.biblioapp.service;


import com.fst.biblioapp.entity.Emprunt;
import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.entity.Livre;
import com.fst.biblioapp.repository.EmpruntRepo;
import com.fst.biblioapp.repository.FournisseurRepo;
import com.fst.biblioapp.repository.LivreRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor //génére automatiquement un constructeur
@FieldDefaults(level = AccessLevel.PRIVATE) //tous les champs de la classe sont définis comme private
@Service
public class LivreServiceImp implements LivreService {

    @Autowired
    private LivreRepo lRepository;
    private FournisseurRepo fRepository;
    private EmpruntRepo eRepository;

    @Override
    public List<Livre> getLivres() {
        return lRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addLivre(Livre livre , Long idFour) {
        Optional<Fournisseur> ofour = fRepository.findById(idFour);
        if (ofour.isPresent()) {
            Fournisseur four = ofour.get();
            livre.setFournisseur(four);
            Livre newlivre = lRepository.save(livre);
            return ResponseEntity.status(HttpStatus.OK).body(newlivre);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fournisseur not found");

    }

    @Override
    public ResponseEntity<?> updateLivre(Livre livre) {
        Optional<Livre> olivre = lRepository.findById(livre.getCoteLivre());
        if(olivre.isPresent()) {
            Livre newlivre = lRepository.save(livre);
            return ResponseEntity.status(HttpStatus.OK).body(newlivre);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre not found ");

    }

    @Override
    public ResponseEntity<String> deleteLivre(long idLivre) {
        Optional<Livre> olivre = lRepository.findById(idLivre);
        if(olivre.isPresent()) {
            Livre livre = olivre.get();
            List<Emprunt> emprunts = eRepository.findByLivre(livre);
            eRepository.deleteAll(emprunts);
            lRepository.deleteById(idLivre);
            return ResponseEntity.ok("Livre deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre not found");
    }
}
