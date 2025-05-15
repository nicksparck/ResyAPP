package com.universidadCentral.Resyapp.controladores;

import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import com.universidadCentral.Resyapp.servicios.ServicioProducto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProductoRest {
    ServicioProducto serProducto;

    @PostMapping("/")
    public Producto crear(Producto producto){
        return serProducto.guardar(producto);
    }

    @GetMapping("/")
    public List<Producto> listar(){
        return serProducto.listar();
    }
}
