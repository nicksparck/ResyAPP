package com.universidadCentral.Resyapp.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nombre",  nullable = false)
    private String nombre;
    @Column(name = "apellido" , nullable = false)
    private String apellido;
    @Column(name = "cedula", length = 18, nullable = false, unique = true)
    private String cedula;
    @Column(name = "nombre_usuario ",nullable = false)
    private String nombreUsuario;
    @Column(name = "Rol", nullable = false)
    private String rol;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

}
