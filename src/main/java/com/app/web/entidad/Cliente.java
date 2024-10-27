package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_cliente" )
	private Integer idCliente;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	@Column(name = "apellido_cliente")
	private String apellidoCliente;
	
	@Column(name = "correo_cliente")
	private String correoCliente;

	@Column( name = "dui_cliente")
	private String duiCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getDuiCliente() {
		return duiCliente;
	}

	public void setDuiCliente(String duiCliente) {
		this.duiCliente = duiCliente;
	}


	@Override
	public String toString() {
		return "Estudiante{" +
				"idCliente=" + idCliente +
				", nombreCliente='" + nombreCliente + '\'' +
				", apellidoCliente='" + apellidoCliente + '\'' +
				", correoCliente='" + correoCliente + '\'' +
				", duiCliente='" + duiCliente + '\'' +
				'}';
	}

	public Cliente() {
	}

	public Cliente(Integer idCliente, String nombreCliente, String apellidoCliente, String correoCliente, String duiCliente) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.correoCliente = correoCliente;
		this.duiCliente = duiCliente;
	}
}
