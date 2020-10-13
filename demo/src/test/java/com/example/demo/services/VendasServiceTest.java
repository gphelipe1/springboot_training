package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entidades.Vendas;
import com.example.demo.repository.VendasRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("manolo")
public class VendasServiceTest {
    @Autowired
    VendasService service;

    @Autowired
    VendasRepository repository;
    
    
    @Test
    public void testaListarVendas(){
        LocalDate date = LocalDate.now();

        Vendas venda1 = Vendas.builder().data_venda(date).build();
        Vendas vendSalv1 = repository.save(venda1);

        Vendas venda2 = Vendas.builder().data_venda(date).build();
        Vendas vendaSalv2 = repository.save(venda2);

        List<Vendas> listaVendas = service.listarVendas();

        Assertions.assertNotNull(listaVendas);
        Assertions.assertEquals(2, listaVendas.size());


    }
}
