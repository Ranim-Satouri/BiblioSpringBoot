package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Emprunt;
import com.fst.biblioapp.entity.Livre;
import com.fst.biblioapp.repository.AdherentRepo;
import com.fst.biblioapp.repository.EmpruntRepo;
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

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmpruntServiceImp implements EmpruntService {
    @Autowired
    private EmpruntRepo eRepository;
    private LivreRepo lRepository;
    private AdherentRepo aRepository;
    @Override
    public List<Emprunt> getEmprunts() {
        return eRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addEmprunt(Emprunt emprunt, Long idLivre, Long idAdherent) {
        Optional<Livre> olivre = lRepository.findById(idLivre);
        if (olivre.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livre not found with ID: " + idLivre);
        }
        Optional<Adherent> oadherent = aRepository.findById(idAdherent);
        if (oadherent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adherent not found with ID: " + idAdherent);
        }
        Livre livre = olivre.get();
        Adherent adherent = oadherent.get();
        emprunt.setLivre(livre);
        emprunt.setAdherent(adherent);
        Emprunt savedEmprunt = eRepository.save(emprunt);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmprunt);
    }


    @Override
    public Emprunt updateEmprunt(Emprunt emprunt) {
        return eRepository.save(emprunt);
    }

    @Override
    public ResponseEntity<String> deleteEmprunt(long idEmp) {
        Optional<Emprunt> Four = eRepository.findById(idEmp);
        if(Four.isPresent()){
            eRepository.deleteById(idEmp);
            return ResponseEntity.ok("Emprunt deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprunt not found");
    }
}
