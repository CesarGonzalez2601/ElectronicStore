package com.app.web.controlador;

import com.app.web.entidad.Producto;
import com.app.web.servicio.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping({ "/productos", "/" })
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoServicio.listarTodosLosProductos());
        return "productos"; // nos retorna al archivo estudiantes
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrtarProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_producto";
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{idProducto}")
    public String mostrarFormularioDeEditar(@PathVariable Integer idProducto, Model modelo) {
        modelo.addAttribute("producto", productoServicio.obtenerProductoPorId(idProducto));
        return "editar_producto";
    }

    @PostMapping("/productos/{idProducto}")
    public String actualizarProducto(@PathVariable Integer idProducto, @ModelAttribute("producto") Producto producto,
                                       Model modelo) {
        Producto productoExistente = productoServicio.obtenerProductoPorId(idProducto);
        productoExistente.setIdProducto(idProducto);
        productoExistente.setNombreProducto(producto.getNombreProducto());
        productoExistente.setIdCategoria(producto.getIdCategoria());

        productoServicio.actualizaProducto(productoExistente);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{idProducto}")
    public String eliminarProducto(@PathVariable Integer idProducto) {
        productoServicio.eliminarProducto(idProducto);
        return "redirect:/productos";
    }

}
