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
    //MODIFICAR USUARIO POR ID
    public void modificar(Long id, Usuario usuarioActual){
        Usuario usuarioExistente = repoUsuario.findById(id).orElseThrow(null);

        //MODIFICAR USUARIO
        usuarioExistente.setNombre(usuarioActual.getNombre());
        usuarioExistente.setApellido(usuarioActual.getApellido());
        usuarioExistente.setCedula(usuarioActual.getCedula());
        usuarioExistente.setNombreUsuario(usuarioActual.getNombreUsuario());
        usuarioExistente.setRol(usuarioActual.getRol());
        usuarioExistente.setContrasena(usuarioActual.getContrasena());
        repoUsuario.save(usuarioExistente);

    }
    // ELIMINAR UN USUARIO POR ID
    public void eliminar(Long id){
        if(!repoUsuario.existsById(id)){
            System.out.println("Usuario por id no encontrado");
        }
        repoUsuario.deleteById(id);
    }
}
