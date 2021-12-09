package com.example.demo.repository;

import com.example.demo.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
    Optional<Orden> findFirstByPlato(String plato);
}
