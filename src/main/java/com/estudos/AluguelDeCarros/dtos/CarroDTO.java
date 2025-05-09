package com.estudos.AluguelDeCarros.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CarroDTO {
    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9][A-Z0-9][0-9]{2}", message = "Placa deve estar no formato ABC1D23")
    private String placa;

    @NotNull
    @Min(1900)
    private int ano;

}
