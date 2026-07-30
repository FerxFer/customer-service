package com.tp.customerservice.dto;

import java.util.List;

public class ClienteConProductosDTO {
    private ClienteResponseDTO cliente;
    private List<ProductoResponseDTO> productos;

    public ClienteConProductosDTO() {}

    public ClienteConProductosDTO(ClienteResponseDTO cliente, List<ProductoResponseDTO> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public ClienteResponseDTO getCliente() { return cliente; }
    public void setCliente(ClienteResponseDTO cliente) { this.cliente = cliente; }

    public List<ProductoResponseDTO> getProductos() { return productos; }
    public void setProductos(List<ProductoResponseDTO> productos) { this.productos = productos; }
}