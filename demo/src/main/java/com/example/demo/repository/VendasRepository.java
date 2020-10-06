package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.MercadoriasNaVenda;

import com.example.demo.entidades.Vendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendasRepository extends JpaRepository <Vendas, Long>{

    @Query("select new com.example.demo.dto.MercadoriaNaVenda(merc)"+
            "from Venda_Mercadoria mv Join Venda_Mercadoria.mercadoria merc"+
            "where mv.venda = :venda")
    List<MercadoriasNaVenda> obterMercadorias(@Param("venda") Vendas venda);
}
