package com.estudos.AluguelDeCarros.controller;

import com.estudos.AluguelDeCarros.dtos.ClienteDTO;
import com.estudos.AluguelDeCarros.entity.Cliente;
import com.estudos.AluguelDeCarros.mapper.ClienteMapper;
import com.estudos.AluguelDeCarros.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    public ClienteDTO criar(@RequestBody @Valid ClienteDTO dto){
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente salvo = clienteService.salvar(cliente);
        return clienteMapper.toDTO(salvo);
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        this.clienteService.remove(id);
    }


}
