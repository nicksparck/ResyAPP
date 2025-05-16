package com.universidadCentral.Resyapp.persistencia.repositorio;


import com.universidadCentral.Resyapp.persistencia.entidades.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;
import java.util.List;

public interface RepositorioIngredientes extends JpaRepository<Ingredientes, Long> {
}
