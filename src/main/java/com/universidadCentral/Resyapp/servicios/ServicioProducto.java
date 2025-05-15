package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto {
    RepositorioProducto repoProducto;

    public Producto guardar(Producto producto){
        return repoProducto.save(producto);
    }

    public List<Producto> listar(){
        return repoProducto.findAll();
    }
}
