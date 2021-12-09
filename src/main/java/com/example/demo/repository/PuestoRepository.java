package com.example.demo.repository;

import com.example.demo.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PuestoRepository extends JpaRepository<Puesto,Long> {
    Optional<Puesto> findByNombre(String nombre);
}
