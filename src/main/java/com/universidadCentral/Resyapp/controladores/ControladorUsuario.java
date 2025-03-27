package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.servicios.ServicioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class ControladorUsuario {
    ServicioUsuario serUsuario;

    // AGREGAR USUARIO
    @PostMapping("/")
    public Usuario guardar(@RequestBody Usuario usuario){
        System.out.println("Este es el usuario:\n" + usuario);
        return serUsuario.guardar(usuario);
    }
    // LISTAR TODOS LOS USUARIOS
    @GetMapping("/")
    public List<Usuario> listar(){
        return serUsuario.listarTodos();
    }
}
