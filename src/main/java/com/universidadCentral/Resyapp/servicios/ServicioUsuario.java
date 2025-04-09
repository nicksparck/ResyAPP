package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.dto.UsuarioDto;
import com.universidadCentral.Resyapp.persistencia.entidades.Rol;
import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioUsuario {
    RepositorioUsuario repoUsuario;

    public Usuario guardar(Usuario usuario){
        return repoUsuario.save(usuario);
    }
    public List<Usuario> listarTodos(){
        return repoUsuario.findAll();
    }
    public UsuarioDto crear(UsuarioDto usuarioDto){
        Rol rol = Rol.builder()
                .tipo_rol(usuarioDto.rol().getTipo_rol())
                .build();
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .nombreUsuario(usuarioDto.nombreUsuario())
                .rol(rol)
                .build();
        if(repoUsuario.save(usuario).getId() > 0){
            return usuarioDto;
        }else return null;
    }
    public Usuario obtenerXNombre(String nombre){
        return repoUsuario.findByNombre(nombre);
    }
    public Usuario obtenerXPk(Long pk){
        return repoUsuario.findById(pk).orElseThrow(null);
    }
}
