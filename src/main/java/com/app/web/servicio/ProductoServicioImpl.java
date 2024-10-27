package com.app.web.servicio;

import com.app.web.entidad.Producto;
import com.app.web.repositorio.ProductosRepositorio;
import com.app.web.servicio.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Override
    public List<Producto> listarTodosLosProductos() {
        return productosRepositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productosRepositorio.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) {
        return productosRepositorio.findById(id).get();
    }

    @Override
    public Producto actualizaProducto(Producto producto) {
        return productosRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productosRepositorio.deleteById(id);
    }

}
