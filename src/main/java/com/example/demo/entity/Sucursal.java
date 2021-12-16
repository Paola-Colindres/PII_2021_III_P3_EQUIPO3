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
@Table (name = "sucursal")

public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String nombre;
    private int    cantidadEmpleados;
    private String direccion;
    private String fechaInicio;
    private int    cantidadClientes;
    private double consumoEnergia;
    private String horaAbre;
    private String horaCierre;
}
