package com.tp.customerservice.exception;

public class ClienteNoEncontradoException extends RuntimeException {

    public ClienteNoEncontradoException(Long id) {
        super("Cliente no encontrado con ID: " + id);
    }

    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}