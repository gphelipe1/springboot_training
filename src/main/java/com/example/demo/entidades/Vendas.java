package com.example.demo.entidades;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vendas
 */

@Entity
@Table(name="Vendas",schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numeroVenda")
    private Long numeroVenda;

    @Column(name="data_venda",nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate data_venda;

}