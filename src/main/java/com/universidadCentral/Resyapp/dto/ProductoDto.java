package com.universidadCentral.Resyapp.dto;

import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import lombok.Data;

import java.util.List;

@Data
public class ProductoDto {
    private String nombre;
    private String descripcion;
    private String imagen;
    private List<Long> ingredientesIds;
}
