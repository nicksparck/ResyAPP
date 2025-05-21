package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.dto.ProductoDto;
import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioIngredientes;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioProducto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioProducto {
    private final RepositorioProducto repoProducto;
    private final RepositorioIngredientes repoIngredientes;

    public Producto guardarDto(ProductoDto dto){
       List<Ingredientes> ingredientes = repoIngredientes.findAllById(dto.getIngredientesIds());

        if (ingredientes.size() != dto.getIngredientesIds().size()) {
            throw new RuntimeException("Algunos ingredientes no fueron encontrados");
        }

        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .imagen(dto.getImagen())
                .ingredientes(ingredientes)
                .build();
        return repoProducto.save(producto);
    }
    // OPTENER INGREDIENTES
    public List<Ingredientes> optenerIngredientes(Long id, ProductoDto dto){
        List<Ingredientes> ingredientes = repoIngredientes.findAllById(dto.getIngredientesIds());
        return ingredientes;
    }
    public List<Producto> listar(){
        return repoProducto.findAll();
    }

    // MODIFICAR PRODUCTO POR ID
    public void modificar(long id, ProductoDto dto){
        Producto productoExistente = repoProducto.findById(id).orElseThrow();
        productoExistente.setNombre(dto.getNombre());
        productoExistente.setDescripcion(dto.getDescripcion());
        productoExistente.setPrecio(dto.getPrecio());
        productoExistente.setIngredientes(optenerIngredientes(id, dto));
        productoExistente.setImagen(dto.getImagen());
        //GUARDAR LOS CAMBIOS
        repoProducto.save(productoExistente);
    }

    // ELIMINAR PRODUCTO POR ID
    public Boolean eliminar(Long id){
        if(!repoProducto.existsById(id)){
            System.out.println("Producto no Encontrado por Id");
            return false;
        }else{
            repoProducto.deleteById(id);
            return true;
        }

    }
}
