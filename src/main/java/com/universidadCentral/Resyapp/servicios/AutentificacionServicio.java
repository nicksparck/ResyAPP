package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.dto.UsuarioCredencialDto;
import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AutentificacionServicio {
    private final RepositorioUsuario usuarioRepo;
    private final PasswordEncoder passwordEncoder; // <- nombre correcto

    public boolean autentificar(String nombreUsuario, String contrasena){
        Optional<Usuario> usuarioOpt = usuarioRepo.findByNombreUsuario(nombreUsuario);
        Usuario usuario = usuarioOpt.get();
        System.out.println("Credencial Usuario " + usuario.getNombreUsuario());
        Optional<Usuario> usuarioOpt2 = usuarioRepo.findByNombreUsuario(nombreUsuario);

        if(usuarioOpt.isPresent()){
            Usuario usuario1 = usuarioOpt2.get();
            return passwordEncoder.matches(contrasena, usuario1.getContrasena());
        }
        return false;
    }


}
