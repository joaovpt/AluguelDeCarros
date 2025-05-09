package com.estudos.AluguelDeCarros.controller;

import com.estudos.AluguelDeCarros.dtos.AluguelDTO;
import com.estudos.AluguelDeCarros.entity.Aluguel;
import com.estudos.AluguelDeCarros.mapper.AluguelMapper;
import com.estudos.AluguelDeCarros.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;
    private final AluguelMapper aluguelMapper;

    public AluguelController(AluguelService aluguelService, AluguelMapper aluguelMapper) {
        this.aluguelService = aluguelService;
        this.aluguelMapper = aluguelMapper;
    }

    @PostMapping
    public AluguelDTO alugar(@RequestBody @Valid AluguelDTO dto){
        return aluguelMapper.toDTO(aluguelService.criarAluguel(dto));
    }

    @PutMapping("/{id}/finalizar")
    public AluguelDTO finalizar(@PathVariable Long id) {
        Aluguel aluguelFinalizado = aluguelService.finalizaAluguel(id);
        return aluguelMapper.toDTO(aluguelFinalizado);
    }
}
