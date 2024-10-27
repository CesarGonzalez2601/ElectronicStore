package com.app.web.entidad;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_producto")
    private Integer idProducto;

    @Column( name = "nombre_producto")
    private String nombreProducto;

    @Column( name = "id_categoria")
    private Integer idCategoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "idProducto=" + idProducto +
                ", nombreProducto=" + nombreProducto +
                ", idCategoria=" + idCategoria +
                '}';
    }

    public Producto(Integer idCategoria, String nombreProducto, Integer idProducto) {
        this.idCategoria = idCategoria;
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
    }

    public Producto() {

    }
}
