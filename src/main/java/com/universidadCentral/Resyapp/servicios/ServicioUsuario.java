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
    // ELIMINAR UN USUARIO POR ID
    public void eliminar(Long id){
        if(!repoUsuario.existsById(id)){
            System.out.println("Usuario por id no encontrado");
        }
        repoUsuario.deleteById(id);
    }
}
