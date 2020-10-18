package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.example.demo.dto.VendasDTO;
import com.example.demo.entidades.Vendas;
import com.example.demo.services.VendasService;
import com.example.demo.services.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/vendas")
public class VendasController {
    @Autowired
    VendasService service;

    @PostMapping("/salva")
    public ResponseEntity salvar(@RequestBody VendasDTO dto) {
        Vendas venda = Vendas.builder().data_venda(dto.getData_venda()).build();

        try {
            Vendas salvo = service.salvar(venda);
            return new ResponseEntity(salvo, HttpStatus.CREATED);

        } catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/vendas")
    public ResponseEntity listarVendas() {
        
        try {
            
            List<Vendas> lista = service.listarVendas();
            return new ResponseEntity(lista, HttpStatus.OK);

        } catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
    
    
}
