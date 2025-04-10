package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import com.universidadCentral.Resyapp.servicios.ServicioIngredientes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
@AllArgsConstructor
public class ControladorIngredientesRest {
    ServicioIngredientes serIngredientes;

    // LISTAR INGREDIENTES
    @GetMapping("/")
    public List<Ingredientes> listar(){
        return serIngredientes.listar();
    }
    @PostMapping("/")
    public Ingredientes guardar(@RequestBody  Ingredientes ingrediente){
        return serIngredientes.crear(ingrediente);
    }
}
