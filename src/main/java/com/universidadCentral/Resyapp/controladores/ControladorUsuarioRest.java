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

    @PutMapping("usuario/{id}/actualizar")
    public ResponseEntity<String> moficiar(@PathVariable Long id, @RequestBody Usuario usuario){
        serUsuario.modificar(id, usuario);
        return ResponseEntity.ok("Se ha modificado el Usuairo Correctamente");
    }
    //ELIMINAR USUARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        serUsuario.eliminar(id);
        return ResponseEntity.ok("Usuario Eliminado Correctamente");

    }



}
