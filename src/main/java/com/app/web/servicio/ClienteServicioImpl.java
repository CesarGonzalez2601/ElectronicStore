package com.app.web.servicio;

import java.util.List;

import com.app.web.servicio.interfaces.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Cliente;
import com.app.web.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> listarTodosLosClientes() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente obtenerClientePorId(Integer id) {
		return clienteRepositorio.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
		public void eliminarCliente(Integer id) {
		clienteRepositorio.deleteById(id);

	}

}
