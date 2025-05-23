package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.dto.UsuarioCredencialDto;
import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioUsuario;
import com.universidadCentral.Resyapp.servicios.AutentificacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/autentificar")
@AllArgsConstructor
public class ControladorAutentificarCredencial {
    AutentificacionServicio autServicio;
    RepositorioUsuario usuarioRepo;
    PasswordEncoder passwordEncoder;
    @PostMapping("/validar")
    public ResponseEntity<?> validarUsuario(@RequestBody UsuarioCredencialDto loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepo.findByNombreUsuario(loginDTO.getNombreUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        if (!passwordEncoder.matches(loginDTO.getContrasena(), usuario.getContrasena())) {
            System.out.println("Contraseña "+loginDTO.getContrasena());
            System.out.println("Usuairo Contraseña "+usuario.getContrasena());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }
        return ResponseEntity.ok("Autenticación exitosa");
    }

}
