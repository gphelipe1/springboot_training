package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entidades.Mercadorias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriasRepository extends JpaRepository <Mercadorias,Long> {
    Optional<Mercadorias> findById(Long id);
}
