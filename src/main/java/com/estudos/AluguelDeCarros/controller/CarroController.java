package com.estudos.AluguelDeCarros.controller;

import com.estudos.AluguelDeCarros.dtos.CarroDTO;
import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.mapper.CarroMapper;
import com.estudos.AluguelDeCarros.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;
    private final CarroMapper carroMapper;

    public CarroController(CarroService carroService, CarroMapper carroMapper) {
        this.carroService = carroService;
        this.carroMapper = carroMapper;
    }

    @PostMapping
    public CarroDTO criar(@RequestBody @Valid CarroDTO dto){
        Carro carro = carroMapper.toEntity(dto);
        Carro salvo = carroService.salvar(carro);
        return carroMapper.toDTO(salvo);
    }

    @GetMapping("/disponiveis")
    public List<Carro> listarDisponiveis(){
        return carroService.listarDisponiveis();
    }

}
