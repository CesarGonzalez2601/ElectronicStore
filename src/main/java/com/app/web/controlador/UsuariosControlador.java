package com.app.web.controlador;

import com.app.web.entidad.Usuario;
import com.app.web.servicio.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosControlador {

    @Autowired
    private UsuarioServicio usuariosServicio;

    @GetMapping({ "/usuarios", "/" })
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("usuarios", usuariosServicio.listarTodosLosUsuarios());
        return "usuarios"; // nos retorna al archivo estudiantes
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuariosServicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{idUsuario}")
    public String mostrarFormularioDeEditar(@PathVariable Integer idUsuario, Model modelo) {
        modelo.addAttribute("usuario", usuariosServicio.obtenerUsuarioPorId(idUsuario));
        return "editar_usuario";
    }

    @PostMapping("/usuarios/{idUsuario}")
    public String actualizarEstudiante(@PathVariable Integer idUsuario, @ModelAttribute("usuario") Usuario usuario,
                                       Model modelo) {
        Usuario usuarioExistente = usuariosServicio.obtenerUsuarioPorId(idUsuario);
        usuarioExistente.setIdUsuario(idUsuario);
        usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        usuarioExistente.setApellidoUsuario(usuario.getApellidoUsuario());
        usuarioExistente.setCorreoUsuario(usuario.getCorreoUsuario());
        usuarioExistente.setContrasena(usuarioExistente.getContrasena());

        usuariosServicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuariosServicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

}
