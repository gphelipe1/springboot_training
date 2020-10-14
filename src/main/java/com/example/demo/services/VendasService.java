package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entidades.Vendas;
import com.example.demo.repository.VendasRepository;
import com.example.demo.services.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //para utilizar o contexto do springboot na camada, diz qual funcionalidade é esperada (serviços)
public class VendasService {

    @Autowired //Para ter acesso aos dados de Vendas
    VendasRepository repository;

    @Transactional //Para atualizar ou salvar. Se fizermos inserts sequenciados, todos serão encapsulados, o commit se dá somente quando todos forem concluidos
    public Vendas salvar(Vendas venda){
        verificarVenda(venda);
        return repository.save(venda);
    }
    public List<Vendas> listarVendas(){
        var found = repository.findAll();

        var vendalist = new ArrayList<Vendas>();
        found.forEach(e -> vendalist.add(e));
        vendalist.forEach(e->verificarId(e));
        return vendalist;
    }

    private void verificarId(Vendas venda){
        if((venda == null) || venda.getNumeroVenda() == null)
            throw new RegraNegocioRunTime("Venda inválida");
    }

    private void verificarVenda(Vendas venda){
        if(venda == null)
            throw new RegraNegocioRunTime("Venda inválida");
        if(venda.getData_venda() == null)
            throw new RegraNegocioRunTime("Data da venda deve ser informada");
    }
    
}
