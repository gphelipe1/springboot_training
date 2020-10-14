package com.example.demo.entidades;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mercadorias
 */

@Entity
@Table(name="mercadorias",schema="public")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mercadorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Long codigo;

    @Column(name="descricao")
    private String descricao;

}