package com.fst.biblioapp.controller;

import com.fst.biblioapp.entity.Adherent;
import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.service.AdherentService;
import com.fst.biblioapp.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdherentController {
    @Autowired
    private AdherentService aService;

    @GetMapping("/getAdherents")
    public List<Adherent> GetAdherents() {
        return aService.getAdherents();
    }

    @PostMapping("/addAdherent")
    public Adherent addUser(@RequestBody Adherent adherent) {
        return aService.addAdherent(adherent);
    }

    @PutMapping("/updateAdherent")
    public ResponseEntity<?> updateAdherent(@RequestBody Adherent adherent){
        return aService.updateAdherent(adherent);
    }

    @DeleteMapping("/deleteAdherent/{idAdh}")
    public ResponseEntity<String> deleteAdherent(@PathVariable("idAdh") long idAdh){
        return aService.deleteAdherent(idAdh);
    }
}
