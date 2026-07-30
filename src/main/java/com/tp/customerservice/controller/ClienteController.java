package com.tp.customerservice.controller;

import com.tp.customerservice.dto.ClienteConProductosDTO;
import com.tp.customerservice.dto.ClienteRequestDTO;
import com.tp.customerservice.dto.ClienteResponseDTO;
import com.tp.customerservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET /clientes - Listar todos
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        List<ClienteResponseDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // GET /clientes/{id} - Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerPorId(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.obtenerPorId(id);
        return ResponseEntity.ok(cliente);
    }

    // GET /clientes/{id}/productos - Obtener cliente con sus productos
    @GetMapping("/{id}/productos")
    public ResponseEntity<ClienteConProductosDTO> obtenerClienteConProductos(@PathVariable Long id) {
        ClienteConProductosDTO resultado = clienteService.obtenerClienteConProductos(id);
        return ResponseEntity.ok(resultado);
    }

    // POST /clientes - Crear cliente
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crear(@RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO clienteCreado = clienteService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }

    // PUT /clientes/{id} - Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO clienteActualizado = clienteService.actualizar(id, dto);
        return ResponseEntity.ok(clienteActualizado);
    }

    // DELETE /clientes/{id} - Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}