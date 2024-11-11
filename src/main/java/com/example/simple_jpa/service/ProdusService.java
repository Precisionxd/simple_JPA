package com.example.simple_jpa.service;

import com.example.simple_jpa.model.Produs;
import com.example.simple_jpa.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> findAll() {
        return produsRepository.findAll();
    }

    public Optional<Produs> findById(Long id) {
        return produsRepository.findById(id);
    }

    public Produs save(Produs produs) {
        return produsRepository.save(produs);
    }

    public void deleteById(Long id) {
        produsRepository.deleteById(id);
    }
}