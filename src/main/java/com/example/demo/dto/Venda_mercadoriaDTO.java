package com.example.demo.dto;

import com.example.demo.entidades.Mercadorias;
import com.example.demo.entidades.Vendas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Venda_mercadoriaDTO {
    private Vendas venda;
    private Mercadorias mercadoria;
}
