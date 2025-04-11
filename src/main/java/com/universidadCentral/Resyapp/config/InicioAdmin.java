package com.universidadCentral.Resyapp.config;

import com.universidadCentral.Resyapp.persistencia.entidades.Roles;
import com.universidadCentral.Resyapp.persistencia.entidades.Usuario;
import com.universidadCentral.Resyapp.persistencia.repositorio.RepositorioUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InicioAdmin {
    @Bean
    CommandLineRunner iniDefaulAdmin(RepositorioUsuario repoUsuario){
        return args -> {
            if(!repoUsuario.existsByRol(Roles.ADMIN)){
                Usuario admin = Usuario.builder()
                        .nombre("admin")
                        .apellido("ad")
                        .nombreUsuario("UserAdmin")
                        .cedula("123456789")
                        .contrasena("Admin123")
                        .rol(Roles.ADMIN)
                        .build();
                repoUsuario.save(admin);
                System.out.println("Adminitrador Creado Correctamente. ");

            }else {
                System.out.println("Administrador ya Existe. ");
            }
        };
    }
}
