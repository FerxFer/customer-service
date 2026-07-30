package com.tp.customerservice.repository;

import com.tp.customerservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Buscar cliente por documento (útil para validar duplicados)
    Optional<Cliente> findByDocumento(String documento);

    // Buscar cliente por email
    Optional<Cliente> findByEmail(String email);
}
