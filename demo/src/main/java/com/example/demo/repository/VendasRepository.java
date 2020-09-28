package com.example.demo.repository;

import com.example.demo.entidades.Vendas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository <Vendas, Long>{
    
}
