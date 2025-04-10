package com.universidadCentral.Resyapp.persistencia.repositorio;


import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioIngredientes extends JpaRepository<Ingredientes, Long> {

}
