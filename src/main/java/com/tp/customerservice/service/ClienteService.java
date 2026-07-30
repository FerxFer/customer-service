package com.tp.customerservice.service;

import com.tp.customerservice.client.ProductoClient;
import com.tp.customerservice.dto.ClienteConProductosDTO;
import com.tp.customerservice.dto.ProductoResponseDTO;
import com.tp.customerservice.dto.ClienteRequestDTO;
import com.tp.customerservice.dto.ClienteResponseDTO;
import com.tp.customerservice.entity.Cliente;
import com.tp.customerservice.exception.ClienteNoEncontradoException;
import com.tp.customerservice.mapper.ClienteMapper;
import com.tp.customerservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ProductoClient productoClient;

    // Obtener cliente con sus productos
    public ClienteConProductosDTO obtenerClienteConProductos(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));

        ClienteResponseDTO clienteDTO = clienteMapper.toResponseDTO(cliente);
        List<ProductoResponseDTO> productos = productoClient.obtenerProductosPorCliente(id);

        return new ClienteConProductosDTO(clienteDTO, productos);
    }

    // Obtener todos los clientes
    public List<ClienteResponseDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Obtener cliente por ID
    public ClienteResponseDTO obtenerPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
        return clienteMapper.toResponseDTO(cliente);
    }

    // Crear cliente
    public ClienteResponseDTO crear(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteGuardado);
    }

    // Actualizar cliente
    public ClienteResponseDTO actualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));

        // Actualizar campos
        cliente.setNombre(dto.getNombre());
        cliente.setDocumento(dto.getDocumento());
        cliente.setEmail(dto.getEmail());
        cliente.setSaldo(dto.getSaldo());

        Cliente clienteActualizado = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteActualizado);
    }

    // Eliminar cliente
    public void eliminar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
        clienteRepository.delete(cliente);
    }
}