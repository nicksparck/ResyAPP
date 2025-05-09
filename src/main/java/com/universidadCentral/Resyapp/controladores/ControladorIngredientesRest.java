package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import com.universidadCentral.Resyapp.servicios.ServicioIngredientes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/ingredientes")
@AllArgsConstructor
@CrossOrigin(origins =  "*")
public class ControladorIngredientesRest {
    ServicioIngredientes serIngredientes;

    // LISTAR INGREDIENTES
    @GetMapping("/")
    public List<Ingredientes> listar(){
        return serIngredientes.listar();
    }

    // GUARDAR INGREDIENTE
    @PostMapping("/")
    public Ingredientes guardar(@RequestBody  Ingredientes ingrediente){
        return serIngredientes.crear(ingrediente);
    }

    // DESCONTAR INGREDIENTE
    @PutMapping("/{id}/descontar")
    public ResponseEntity<String> descontarIngrediente(@PathVariable Long id, @RequestParam int cantidad){
        int totalIngrediente= serIngredientes.descontarCantidad(id, cantidad);
        if(totalIngrediente <= 5){
            return ResponseEntity.ok("⚠\uFE0F Actualice su inventario tienes pocos ingredientes");
        } return ResponseEntity.ok("Cantidad descontada correctamente " + totalIngrediente);
    }
    // AUMENTAR CANTIDAD INGREDIENTE
    @PutMapping("/agregar/{id}/aumentar")
    public ResponseEntity<String> aumentarCantidad(@PathVariable Long id, @RequestParam int cantidad){
        serIngredientes.agregarCantidad(id, cantidad);
        return ResponseEntity.ok("Cantidad Actualizada Correctamente");
    }

    // ELIMINAR ELEMENTO DEL INVENTARIO
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id){
        serIngredientes.eliminarIngrediente(id);
        return ResponseEntity.ok("Eliminacion Ingrediente Correctamente");
    }


}
