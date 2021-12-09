package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "reservaciones")

public class Reservaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String cliente;
    private String sucursal;
    private String horaInicio;
    private String horaFinal;
    private int    cantidadPersonas;
    private Date   fecha;
    private double precioReservacion;
}
