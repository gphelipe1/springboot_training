package com.example.demo.entidades;

import java.util.Objects;

import javax.persistence.*;

/**
 * Mercadorias
 */

@Entity
@Table(name="mercadorias",schema="public")

public class Mercadorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Long codigo;

    @Column(name="descricao")
    private String descricao;

    //Construtor
    public Mercadorias(){}

    //Gets e Sets
    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mercadorias)) {
            return false;
        }
        Mercadorias mercadorias = (Mercadorias) o;
        return Objects.equals(codigo, mercadorias.codigo) && Objects.equals(descricao, mercadorias.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao);
    }


}