package com.universidadCentral.Resyapp.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.prefs.Preferences;

@Entity
@Table(name = "rol_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name= "tipo_rol")
    private String tipo_rol;

}
