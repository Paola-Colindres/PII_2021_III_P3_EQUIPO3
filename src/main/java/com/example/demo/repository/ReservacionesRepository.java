package com.example.demo.repository;

import com.example.demo.entity.Reservaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservacionesRepository extends JpaRepository<Reservaciones, Long> {
    Optional<Reservaciones> findByCliente(String cliente);
}
