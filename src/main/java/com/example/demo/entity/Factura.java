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
@Table(name = "factura")

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    private String cliente;
    private String empleado;
    private String orden;
    private String fecha;
    private int    cantidadOrden;
    private String tipoPago;
    private double totalPagar;
}
