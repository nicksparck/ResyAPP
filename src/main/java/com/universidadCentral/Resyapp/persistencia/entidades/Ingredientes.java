package com.universidadCentral.Resyapp.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredientes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidad;
    private boolean esAlimenticio;
    // CREAR RELACION CON PROVEDORES

}
