package com.example.demo.entidades;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * Vendas
 */

@Entity
@Table(name="Vendas",schema="public")

public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numeroVenda")
    private Long numeroVenda;

    @Column(name="data_venda")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate data_venda;


    //Construtor
    public Vendas(){}

    //Gets e Sets
    public Long getNumeroVenda() {
        return this.numeroVenda;
    }

    public void setNumeroVenda(Long numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public LocalDate getData_venda() {
        return this.data_venda;
    }

    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }

    @Override
    public String toString() {
        return "{" +
            " numeroVenda='" + getNumeroVenda() + "'" +
            ", data_venda='" + getData_venda() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vendas)) {
            return false;
        }
        Vendas vendas = (Vendas) o;
        return Objects.equals(numeroVenda, vendas.numeroVenda) && Objects.equals(data_venda, vendas.data_venda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroVenda, data_venda);
    }


}