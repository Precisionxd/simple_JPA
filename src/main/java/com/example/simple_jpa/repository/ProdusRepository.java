package com.example.simple_jpa.repository;

import com.example.simple_jpa.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
}