package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Emprunt;
import com.fst.biblioapp.repository.AdherentRepo;
import com.fst.biblioapp.repository.EmpruntRepo;
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
public class AdherentServiceImp implements AdherentService {
    @Autowired
    private AdherentRepo aRepository;
    private EmpruntRepo eRepository;
    @Override
    public List<Adherent> getAdherents() {
        return aRepository.findAll();
    }

    @Override
    public Adherent addAdherent(Adherent adherent) {
        return aRepository.save(adherent);
    }

    @Override
    public ResponseEntity<?> updateAdherent(Adherent adherent) {
        Optional<Adherent> oadherent = aRepository.findById(adherent.getIdAdherent());
        if(oadherent.isPresent()) {
            Adherent adh = aRepository.save(adherent);
            return ResponseEntity.status(HttpStatus.OK).body(adh);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adherent not found ");

    }

    @Override
    public ResponseEntity<String> deleteAdherent(long idAdherent) {
        Optional<Adherent> oAdh = aRepository.findById(idAdherent);
        if(oAdh.isPresent()){
            Adherent adherent = oAdh.get();
            List<Emprunt> emprunts = eRepository.findByAdherent(adherent);
            eRepository.deleteAll(emprunts);
            System.out.println("deleted emprunts");
            aRepository.deleteById(idAdherent);
            return ResponseEntity.ok("Adherent deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adherent not found");
    }
}
