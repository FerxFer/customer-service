package com.tp.customerservice.client;

import com.tp.customerservice.dto.ProductoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductoClient {

    @GetMapping("/api/productos/cliente/{clienteId}")
    List<ProductoResponseDTO> obtenerProductosPorCliente(@PathVariable("clienteId") Long clienteId);
}