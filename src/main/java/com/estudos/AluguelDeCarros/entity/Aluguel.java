package com.estudos.AluguelDeCarros.entity;

import com.estudos.AluguelDeCarros.enums.StatusAluguel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_aluguel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @NotNull
    private LocalDate data_inicio;

    @NotNull
    @Future
    private LocalDate data_fim;

    @Enumerated(EnumType.STRING)
    private StatusAluguel statusAluguel = StatusAluguel.ATIVO;
}
