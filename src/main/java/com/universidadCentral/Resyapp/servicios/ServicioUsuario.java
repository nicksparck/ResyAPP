package com.universidadCentral.Resyapp.servicios;

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
}
