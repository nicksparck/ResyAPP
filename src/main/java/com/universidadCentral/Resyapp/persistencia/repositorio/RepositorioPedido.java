package com.universidadCentral.Resyapp.persistencia.repositorio;


import com.universidadCentral.Resyapp.persistencia.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {
}
