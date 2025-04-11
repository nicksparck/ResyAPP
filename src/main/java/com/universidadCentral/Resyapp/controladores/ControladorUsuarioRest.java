package com.universidadCentral.Resyapp.controladores;


import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.servicios.ServicioUsuario;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class ControladorUsuarioRest {
    ServicioUsuario serUsuario;

    @PostMapping("/")
    public Usuario guardar(@RequestBody Usuario usuario){
        System.out.println("Este es el usuario:\n" + usuario);
        return serUsuario.guardar(usuario);
    }
    @GetMapping("/")
    public List<Usuario> listar(){
        return serUsuario.listarTodos();
    }



}
