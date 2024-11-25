package com.fst.biblioapp.service;

import com.fst.biblioapp.entity.Adherent;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface AdherentService {
    List<Adherent> getAdherents();
    Adherent addAdherent(Adherent adherent);
    ResponseEntity<?> updateAdherent(Adherent adherent);
    ResponseEntity<String> deleteAdherent(long idFour);

}
