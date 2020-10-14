package com.example.demo.repository;

import com.example.demo.entidades.Venda_mercadoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Venda_MercadoriaRepository extends JpaRepository <Venda_mercadoria, Long> {
    
}
