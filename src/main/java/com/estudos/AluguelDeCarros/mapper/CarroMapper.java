package com.estudos.AluguelDeCarros.mapper;

import com.estudos.AluguelDeCarros.dtos.CarroDTO;
import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.enums.StatusCarro;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public Carro toEntity(CarroDTO dto){
        Carro carro = new Carro();
        carro.setModelo(dto.getModelo());
        carro.setMarca(dto.getMarca());
        carro.setPlaca(dto.getPlaca());
        carro.setAno(dto.getAno());
        carro.setStatus(StatusCarro.DISPONIVEL);
        return carro;
    }

    public CarroDTO toDTO(Carro carro){
        CarroDTO dto = new CarroDTO();
        dto.setModelo(carro.getModelo());
        dto.setMarca(carro.getMarca());
        dto.setPlaca(carro.getPlaca());
        dto.setAno(carro.getAno());
        return dto;
    }

}
