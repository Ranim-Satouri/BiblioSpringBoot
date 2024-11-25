package com.fst.biblioapp.controller;
import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FournisseurController {
    @Autowired
    private FournisseurService fService;

    @GetMapping("/getFournisseurs")
    public List<Fournisseur> GetFournisseurs() {
        return fService.getfournisseurs();
    }

    @PostMapping("/addFournisseur")
    public Fournisseur addUser(@RequestBody Fournisseur fournisseur) {
        return fService.addFournisseur(fournisseur);
    }

    @PutMapping("/updateFournisseur")
    public ResponseEntity<?>  updateFournisseur(@RequestBody Fournisseur fournisseur){
        return fService.updateFournissuer(fournisseur);
    }

    @DeleteMapping("/deleteFournisseur/{idFour}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable("idFour") long idFour){
        return fService.deleteFournisseur(idFour);
    }
}
