package com.example.simple_jpa.controller;

import com.example.simple_jpa.model.Produs;
import com.example.simple_jpa.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable Long id) {
        return produsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsService.save(produs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produs> updateProdus(@PathVariable Long id, @RequestBody Produs produsDetails) {
        return produsService.findById(id)
                .map(produs -> {
                    produs.setNume(produsDetails.getNume());
                    produs.setPret(produsDetails.getPret());
                    produs.setDescriere(produsDetails.getDescriere());
                    produsService.save(produs);
                    return ResponseEntity.ok(produs);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        if (produsService.findById(id).isPresent()) {
            produsService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
