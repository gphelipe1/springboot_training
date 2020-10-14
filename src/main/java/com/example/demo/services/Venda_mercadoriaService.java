package com.example.demo.services;

import java.util.List;

import com.example.demo.entidades.Venda_mercadoria;
import com.example.demo.repository.Venda_MercadoriaRepository;
import com.example.demo.services.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

@Service
public class Venda_mercadoriaService {
    @Autowired
    Venda_MercadoriaRepository repository;

    public Venda_mercadoria salvar(Venda_mercadoria vendaMerc){
        verificarVendaMerc(vendaMerc);
        return repository.save(vendaMerc);

    }

    public Venda_mercadoria atualizar(Venda_mercadoria vendaMerc){
        verificarId(vendaMerc);
        return salvar(vendaMerc);
    }

    private void verificarId(Venda_mercadoria vendaMerc){
        if((vendaMerc == null) || vendaMerc.getId_venda_mercadoria() == null)
            throw new RegraNegocioRunTime("Venda inválida");
    }

    private void verificarVendaMerc(Venda_mercadoria vendaMerc){
        if(vendaMerc == null)
            throw new RegraNegocioRunTime("Venda de mercadorias inválida");
        if(vendaMerc.getVenda() == null)
            throw new RegraNegocioRunTime("Venda inválida");
        if(vendaMerc.getMercadoria() == null)
            throw new RegraNegocioRunTime("Mercadoria inválida");
    }

    public List<Venda_mercadoria> buscar(Venda_mercadoria filtro){
        Example<Venda_mercadoria> example = 
            Example.of(filtro, ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }
    
}
