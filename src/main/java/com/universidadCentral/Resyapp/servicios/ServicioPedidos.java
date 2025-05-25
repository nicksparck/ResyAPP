package com.universidadCentral.Resyapp.servicios;

import com.universidadCentral.Resyapp.persistencia.entidades.Pedido;
import com.universidadCentral.Resyapp.persistencia.entidades.Producto;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioPedido;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioPedidos {
    RepositorioPedido repoPedido;

    public Pedido guardar(Pedido pedido){
        return repoPedido.save(pedido);
    }
    public List<Pedido> lista(){
        return repoPedido.findAll();
    }
}
