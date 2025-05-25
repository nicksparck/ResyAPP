package com.universidadCentral.Resyapp.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String imagen;
    // RELACION ENTRE PRODUCTOS Y INGREDIENTES
    @ManyToMany
    @JoinTable(
            name = "producto_ingrediente",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingredientes> ingredientes = new ArrayList<>();
}
