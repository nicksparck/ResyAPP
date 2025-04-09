package com.universidadCentral.Resyapp.persistencia.repositorio;

import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    @Query(value = """
            SELECT u FROM Usuario u
            WHERE UPPER(u.nombre) = UPPER(?1) """)
    Usuario findByNombre(String nombre);
    Usuario findByNombreAndNombreUsuario(String nombre, String nombreUsuario);

}
