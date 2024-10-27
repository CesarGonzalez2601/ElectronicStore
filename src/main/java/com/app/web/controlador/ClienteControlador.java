package com.app.web.controlador;

import com.app.web.servicio.interfaces.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Cliente;

@Controller
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping({ "/clientes", "/" })
	public String listarClientes(Model modelo) {
		modelo.addAttribute("clientes", clienteServicio.listarTodosLosClientes());
		return "clientes"; // nos retorna al archivo clientes
	}

	@GetMapping("/clientes/nuevo")
	public String mostrarFormularioDeRegistrtarCliente(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "crear_cliente";
	}

	@PostMapping("/clientes")
	public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.guardarCliente(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("cliente", clienteServicio.obtenerClientePorId(id));
		return "editar_cliente";
	}

	@PostMapping("/clientes/{id}")
	public String actualizarCliente(@PathVariable Integer id, @ModelAttribute("cliente") Cliente cliente,
			Model modelo) {
		Cliente clienteExistente = clienteServicio.obtenerClientePorId(id);
		clienteExistente.setIdCliente(id);
		clienteExistente.setNombreCliente(cliente.getNombreCliente());
		clienteExistente.setApellidoCliente(cliente.getApellidoCliente());
		clienteExistente.setCorreoCliente(cliente.getCorreoCliente());
		clienteExistente.setDuiCliente(cliente.getDuiCliente());

		clienteServicio.actualizarCliente(clienteExistente);
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/{id}")
	public String eliminarCliente(@PathVariable Integer id) {
		clienteServicio.eliminarCliente(id);
		return "redirect:/clientes";
	}
}
