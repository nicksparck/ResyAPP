package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.servicios.ServicioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    @GetMapping("/")
    public List<Usuario> listar(){
        return serUsuario.listarTodos();
    }

    // LISTAR TODOS LOS USUARIOS USANDO HTML
    @GetMapping("/listaUsuarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", serUsuario.listarTodos());
        return "listar"; // Thymeleaf buscará listar.html en src/main/resources/templates/
    }
}
