package com.fst.biblioapp.controller;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Emprunt;
import com.fst.biblioapp.service.AdherentService;
import com.fst.biblioapp.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpruntController {
    @Autowired
    private EmpruntService eService;

    @GetMapping("/getEmprunts")
    public List<Emprunt> GetEmprunts() {
        return eService.getEmprunts();
    }

    @PostMapping("/addEmprunt/{idLivre}/{idAdherent}")
    public ResponseEntity<?> addUser(@RequestBody Emprunt emprunt , @PathVariable Long idLivre , @PathVariable Long idAdherent) {
        return eService.addEmprunt(emprunt,idLivre,idAdherent);
    }

    @PutMapping("/updateEmprunt")
    public Emprunt updateEmprunt(@RequestBody Emprunt emprunt){
        return eService.updateEmprunt(emprunt);
    }

    @DeleteMapping("/deleteEmprunt/{idemp}")
    public ResponseEntity<String> deleteEmprunt(@PathVariable("idemp") long idemp){
        return eService.deleteEmprunt(idemp);
    }
}
