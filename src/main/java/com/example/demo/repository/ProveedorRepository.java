package com.example.demo.repository;

import com.example.demo.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {
    Optional<Proveedor> findByNombre(String nombre);
}
