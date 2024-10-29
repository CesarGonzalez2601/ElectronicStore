package com.app.web.controlador;

import com.app.web.entidad.Cliente;
import com.app.web.entidad.Producto;
import com.app.web.entidad.Usuario;
import com.app.web.repositorio.ClienteRepositorio;
import com.app.web.repositorio.ProductosRepositorio;
import com.app.web.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/home")
    public String mostrarHome() {
        return "home"; // Muestra la página de inicio
    }

    @GetMapping("/pagina1")
    public String mostrarClientes(Model model) {
        List<Cliente> clientes = clienteRepositorio.findAll(); // Obtiene todos los clientes
        model.addAttribute("clientes", clientes); // Añade la lista de clientes al modelo
        return "clientes";
    }

    @GetMapping("/pagina2")
    public String mostrarPagina2(Model model) {
        List<Producto> productos = productosRepositorio.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/pagina3")
    public String mostrarPagina3(Model model) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
}
