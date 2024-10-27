package com.app.web.servicio.interfaces;

import com.app.web.entidad.Producto;

import java.util.List;

public interface ProductoServicio {

    public List<Producto> listarTodosLosProductos();

    public Producto guardarProducto(Producto producto);

    public Producto obtenerProductoPorId(Integer id);

    public Producto actualizaProducto(Producto producto);

    public void eliminarProducto(Integer id);
}
