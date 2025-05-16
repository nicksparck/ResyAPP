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
                .ingredientes(ingredientes)
                .build();
        return repoProducto.save(producto);
    }

    public List<Producto> listar(){
        return repoProducto.findAll();
    }
}
