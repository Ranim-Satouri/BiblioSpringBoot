package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.entity.Livre;
import com.fst.biblioapp.repository.FournisseurRepo;
import com.fst.biblioapp.repository.LivreRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class FournissuerServiceImp implements  FournisseurService{
    @Autowired
    private FournisseurRepo  fRepository;
    private LivreRepo lRepository;

    @Override
    public List<Fournisseur> getfournisseurs() {
        return fRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fRepository.save(fournisseur);
    }
    @Override
    public ResponseEntity<?> updateFournissuer(Fournisseur fournisseur){
        Optional<Fournisseur> ofournisseur = fRepository.findById(fournisseur.getIdFour());
        if(ofournisseur.isPresent()) {
            Fournisseur four = fRepository.save(fournisseur);
            return ResponseEntity.status(HttpStatus.OK).body(four);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fournisseur not found ");

    }

    @Override
    public ResponseEntity<String> deleteFournisseur(long idFour) {
        Optional<Fournisseur> ofour =fRepository.findById(idFour);
        if(ofour.isPresent()){
            Fournisseur four = ofour.get();
            List<Livre> livres = lRepository.findByFournisseur(four);
            lRepository.deleteAll(livres);
            fRepository.deleteById(idFour);
            return ResponseEntity.ok("Fournissauer deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fourniiseur not found");
    }

}
