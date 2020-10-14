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
        Vendas vendaSalv1 = repository.save(venda1);

        Assertions.assertNotNull(vendaSalv1);
        Assertions.assertEquals(venda1.getNumeroVenda(), vendaSalv1.getNumeroVenda());
        Assertions.assertEquals(venda1.getData_venda(), vendaSalv1.getData_venda());

        Vendas venda2 = Vendas.builder().data_venda(date).build();
        Vendas vendaSalv2 = repository.save(venda2);

        Assertions.assertNotNull(vendaSalv2);
        Assertions.assertEquals(venda2.getNumeroVenda(), vendaSalv2.getNumeroVenda());
        Assertions.assertEquals(venda2.getData_venda(), vendaSalv2.getData_venda());

        List<Vendas> listaVendas = service.listarVendas();

        Assertions.assertNotNull(listaVendas);
        Assertions.assertEquals(2, listaVendas.size());


    }
}
