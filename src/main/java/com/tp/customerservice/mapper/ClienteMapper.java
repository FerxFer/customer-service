package com.tp.customerservice.mapper;

import com.tp.customerservice.dto.ClienteRequestDTO;
import com.tp.customerservice.dto.ClienteResponseDTO;
import com.tp.customerservice.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    // Convertir DTO de request a Entidad
    public Cliente toEntity(ClienteRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setDocumento(dto.getDocumento());
        cliente.setEmail(dto.getEmail());
        cliente.setSaldo(dto.getSaldo());

        return cliente;
    }

    // Convertir Entidad a DTO de response
    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setSaldo(cliente.getSaldo());

        return dto;
    }
}