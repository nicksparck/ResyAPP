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
}
