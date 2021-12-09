package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orden")

public class Orden {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long   id;
    private String plato;
    private String bebida;
    private String extra;
    private String complemento;
    private int    cantidad;
    private String postre;
    private double precioTotal;
}
