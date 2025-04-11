package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioIngredientes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioIngredientes {
    RepositorioIngredientes repoIngredientes;
    // CREAR INGREDIENTES
    public Ingredientes crear(Ingredientes ingrediente){
        return repoIngredientes.save(ingrediente);
    }
    //LISTAR INGREDIENTES
    public List<Ingredientes> listar(){
        return repoIngredientes.findAll();
    }

    // DESCONTAR INGREDIENTE
    public int descontarCantidad(Long idIngrediente, int cantidadDescontar){
        Ingredientes ingrediente = repoIngredientes.findById(idIngrediente).orElseThrow(null);

        int nuevaCantidad = ingrediente.getCantidad() - cantidadDescontar;
        if(nuevaCantidad < 0){
            System.out.println("No hay suficiente Cantidad en el Inventario");
        }
        ingrediente.setCantidad(nuevaCantidad);
        repoIngredientes.save(ingrediente);
        // RETORNA CANTIDAD DESCONTADA
        return nuevaCantidad;
    }

    // AGREGAR INGREDIENTE
    public void agregarCantidad(Long idIngrediente, int cantidad){
        Ingredientes ingrediente = repoIngredientes.findById(idIngrediente).orElseThrow(null);

        if(cantidad > 0){
            int nuevaCantidad = ingrediente.getCantidad() + cantidad;
            ingrediente.setCantidad(nuevaCantidad);
            repoIngredientes.save(ingrediente);
        }else{
            System.out.println("No podemos ingresar 0 Unidades ");
        }
    }

    // ELIMINAR INGREDIENTE DEL INVENTARIO
    public void eliminarIngrediente(Long id){
        if(!repoIngredientes.existsById(id)){
            System.out.println("Ingrediente por id no encontrado");

        }
        repoIngredientes.deleteById(id);
    }
}
