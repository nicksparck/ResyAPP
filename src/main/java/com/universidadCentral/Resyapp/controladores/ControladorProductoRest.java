package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.dto.ProductoDto;
import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import com.universidadCentral.Resyapp.servicios.ServicioProducto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ControladorProductoRest {
    private final ServicioProducto serProducto;

    @GetMapping("/")
    public List<Producto> listar(){
        return serProducto.listar();
    }

    @PostMapping("/")
    public ResponseEntity<String> crear(@RequestBody ProductoDto productoDto){
        try {
            serProducto.guardarDto(productoDto);
            return ResponseEntity.ok("Producto Agregado");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable long id){
        serProducto.eliminar(id);
        return ResponseEntity.ok("Producto Eliminado con Exito");
    }


}
