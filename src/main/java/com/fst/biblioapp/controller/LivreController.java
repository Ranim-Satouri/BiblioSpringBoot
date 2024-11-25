package com.fst.biblioapp.controller;

import com.fst.biblioapp.entity.Fournisseur;
import com.fst.biblioapp.entity.Livre;
import com.fst.biblioapp.service.FournisseurService;
import com.fst.biblioapp.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreController {
    @Autowired
    private LivreService lService;

    @GetMapping("/getLivres")
    public List<Livre> GetLivres() {
        return lService.getLivres();
    }

    @PostMapping("/addLivre/{idFour}")
    public ResponseEntity<?> addLivre(@RequestBody Livre livre , @PathVariable Long idFour) {
        return lService.addLivre(livre , idFour);
    }

    @PutMapping("/updateLivre")
    public ResponseEntity<?> updateLivre(@RequestBody Livre livre){
        return lService.updateLivre(livre);
    }

    @DeleteMapping("/deleteLivre/{idLivre}")
    public ResponseEntity<String> deleteLivre(@PathVariable("idLivre") long idLivre){
        return lService.deleteLivre(idLivre);
    }

}
