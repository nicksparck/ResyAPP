package com.universidadCentral.Resyapp.persistencia.repositorio;

import com.universidadCentral.Resyapp.persistencia.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRol extends JpaRepository<Rol, Long> {
}
