package com.app.web.repositorio;

import com.app.web.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Integer>{

    Optional<Usuario> findByCorreoUsuario(String correoUsuario);

}
