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
@CrossOrigin(origins = "*")
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
         Boolean idEncontrado = serProducto.eliminar(id);
         if(idEncontrado){
             return ResponseEntity.ok("Producto Eliminado con Exito");
         } else{
             return ResponseEntity.badRequest().body("Producto no Encontrado por Id");
         }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody ProductoDto dto){
        try{
            serProducto.modificar(id, dto);
            return ResponseEntity.ok("Producto Modificado con Exito");
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Error al Modificar el Producto");
        }
    }


}
