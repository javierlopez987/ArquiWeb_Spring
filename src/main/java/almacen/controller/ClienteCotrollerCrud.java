package almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import almacen.crud.ClienteCrud;
import almacen.model.Cliente;

@RestController
public abstract class ClienteCotrollerCrud {

	@Autowired
	private ClienteCrud clienteCrud;

	@GetMapping("/clientes")
	public Iterable<Cliente> getCliente() {
		return clienteCrud.findAll();
	}

	@PostMapping("/clientes")
	public Cliente newCliente(@RequestBody Cliente c) {
		return clienteCrud.save(c);
	}

}
