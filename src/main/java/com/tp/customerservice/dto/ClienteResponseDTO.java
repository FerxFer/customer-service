package com.tp.customerservice.dto;

import java.math.BigDecimal;

public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private BigDecimal saldo;

    public ClienteResponseDTO() {}

    public ClienteResponseDTO(Long id, String nombre, String email, BigDecimal saldo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.saldo = saldo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
}