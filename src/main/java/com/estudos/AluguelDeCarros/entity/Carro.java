package com.estudos.AluguelDeCarros.entity;

import com.estudos.AluguelDeCarros.enums.StatusCarro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String marca;

    @Column(unique = true)
    private String placa;

    private int ano;

    @Enumerated (EnumType.STRING)
    private StatusCarro status = StatusCarro.DISPONIVEL;

    @OneToMany(mappedBy = "carro")
    @JsonIgnore
    private List<Aluguel> alugueis;
}
