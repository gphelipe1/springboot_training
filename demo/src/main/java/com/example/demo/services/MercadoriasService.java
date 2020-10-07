package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entidades.Mercadorias;
import com.example.demo.entidades.Vendas;
import com.example.demo.repository.MercadoriasRepository;
import com.example.demo.services.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

@Service
public class MercadoriasService {
    @Autowired
    MercadoriasRepository repository;
    
    @Autowired
    VendasService venda;

    public Mercadorias salvar(Mercadorias mercadoria){
        verificarMercadoria(mercadoria);
        return repository.save(mercadoria);
    }

    public Mercadorias atualizar(Mercadorias mercadoria){
        verificarId(mercadoria);
        return salvar(mercadoria);
    } 

    public void venderMercadoria(Mercadorias mercadoria, Vendas newVenda){
        verificarId(mercadoria);
        verificarMercadoria(mercadoria);
        repository.delete(mercadoria);
        venda.salvar(newVenda);
    }

    public void verificarId(Mercadorias mercadoria){
        if((mercadoria == null) || mercadoria.getCodigo()== null)
            throw new RegraNegocioRunTime("Mercadoria inválida");
    }

    public void verificarMercadoria(Mercadorias mercadoria){
        if(mercadoria == null)
            throw new RegraNegocioRunTime("Mercadoria não cadastrada");
        if(mercadoria.getDescricao() == null)
            throw new RegraNegocioRunTime("O produto deve ter uma descrição");
    }

    public Optional<Mercadorias> buscarPorId(Long id){
        Optional<Mercadorias> merc = repository.findById(id);
        if( !merc.isPresent() )
            throw new RegraNegocioRunTime("Mercadoria não encontrada");
        return merc;
    }

    public List<Mercadorias> buscar(Mercadorias filtro){
        Example<Mercadorias> example = 
            Example.of(filtro, ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }
}
