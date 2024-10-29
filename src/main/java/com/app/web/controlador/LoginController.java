package com.app.web.controlador;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Muestra el formulario de login
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("password") String password,
                                Model model) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(correo);

        if (usuarioOpt.isPresent() && usuarioOpt.get().getContrasena().equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", true); // Muestra mensaje de error en el formulario
            return "login";
        }
    }
}

