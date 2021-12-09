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
@Table(name = "puesto")

public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String nombre;
    private String estudioMinimo;
    private int    cantidadEmpleados;
    private String usoUniforme;
    private Date   fechaInicio;
    private String descripcion;
    private String experiencia;
}
