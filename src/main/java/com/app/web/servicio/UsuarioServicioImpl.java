package com.app.web.servicio;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;
import com.app.web.servicio.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }


    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepositorio.findById(id).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario Usuario) {

        return usuarioRepositorio.save(Usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);

    }
}
