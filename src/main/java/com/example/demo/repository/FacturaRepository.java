package com.example.demo.repository;

import com.example.demo.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Optional<Factura> findFirstByCliente(String cliente);
}
