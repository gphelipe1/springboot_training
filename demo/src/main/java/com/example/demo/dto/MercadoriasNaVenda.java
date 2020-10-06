package com.example.demo.dto;

import com.example.demo.entidades.Mercadorias;
//import com.example.demo.entidades.Venda_mercadoria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MercadoriasNaVenda {
    //private Venda_mercadoria mv;
    private Mercadorias merc;
}
