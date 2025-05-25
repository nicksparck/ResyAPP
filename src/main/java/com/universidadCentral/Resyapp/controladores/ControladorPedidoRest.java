package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Pedido;
import com.universidadCentral.Resyapp.servicios.ServicioPedidos;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class ControladorPedidoRest {
    ServicioPedidos serPedido;

    //GUARDAR
    @PostMapping("/")
    public ResponseEntity<String> guardar(@RequestBody Pedido pedido){
        try{
            serPedido.guardar(pedido);
            return ResponseEntity.ok("Pedido Guardado");
        } catch( Exception e){
            return ResponseEntity.badRequest().body("Error al ingresar Pedido");
        }
    }
    @GetMapping("/")
    public List<Pedido> verLista(){
        return serPedido.lista();
    }
    // ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        try{
            serPedido.eliminarPedido(id);
            return  ResponseEntity.ok("Pedido Eliminado con Exito");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error Pedido no encontrado");
        }
    }
}
