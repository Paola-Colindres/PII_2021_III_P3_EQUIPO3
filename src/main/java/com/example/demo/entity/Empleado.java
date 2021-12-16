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
@Table (name = "empleado")

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String nombre;
    private long   dni;
    private double sueldo;
    private String sucursal;
    private String fechaIngreso;
    private String genero;
    private int    edad;
    private int    horas;
    private double precioHora;
}
