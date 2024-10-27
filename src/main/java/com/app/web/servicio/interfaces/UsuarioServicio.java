package com.app.web.servicio.interfaces;

import com.app.web.entidad.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> listarTodosLosUsuarios();

    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorId(Integer id);

    public Usuario actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Integer id);
}
