package com.universidadCentral.Resyapp.dto;

import com.universidadCentral.Resyapp.persistencia.entidades.Rol;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record UsuarioDto(@NotBlank
                         String nombreUsuario,
                         String nombre,
                         String apellido,
                         String cedula,
                         Rol rol
){
}
