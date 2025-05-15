package com.universidadCentral.Resyapp.persistencia.repositorio;

import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {

}
