package com.example.demo.entidades;

import java.util.Objects;

import javax.persistence.*;


/**
 * Venda_mercadoria
 */

@Entity
@Table(name="Venda_Mercadoria",schema="public")

public class Venda_mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda_mercadoria;
    
    @ManyToOne
    @JoinColumn(name="numeroVenda")
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name="codigo")
    private Mercadorias mercadoria;

    public Venda_mercadoria(){}


    public Long getId_venda_mercadoria() {
        return this.id_venda_mercadoria;
    }

    public void setId_venda_mercadoria(Long id_venda_mercadoria) {
        this.id_venda_mercadoria = id_venda_mercadoria;
    }

    public Vendas getVenda() {
        return this.venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Mercadorias getMercadoria() {
        return this.mercadoria;
    }

    public void setMercadoria(Mercadorias mercadoria) {
        this.mercadoria = mercadoria;
    }

    @Override
    public String toString() {
        return "{" +
            " id_venda_mercadoria='" + getId_venda_mercadoria() + "'" +
            ", venda='" + getVenda() + "'" +
            ", mercadoria='" + getMercadoria() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Venda_mercadoria)) {
            return false;
        }
        Venda_mercadoria venda_mercadoria = (Venda_mercadoria) o;
        return Objects.equals(id_venda_mercadoria, venda_mercadoria.id_venda_mercadoria) && Objects.equals(venda, venda_mercadoria.venda) && Objects.equals(mercadoria, venda_mercadoria.mercadoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_venda_mercadoria, venda, mercadoria);
    }

}