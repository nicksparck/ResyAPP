package com.universidadCentral.Resyapp.persistencia.repositorio;

import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
