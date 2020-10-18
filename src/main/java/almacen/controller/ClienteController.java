package almacen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almacen.model.Cliente;
import almacen.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Qualifier("clienteRepository")
	@Autowired
	private final ClienteRepository repository;

	public ClienteController(@Qualifier("clienteRepository") ClienteRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public Iterable<Cliente> getClientes() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> one(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping("/")
	public Cliente newCliente(@RequestBody Cliente c) {
		return repository.save(c);
	}

	@PutMapping("/{id}")
	Cliente replaceCliente(@RequestBody Cliente newCliente, @PathVariable Long id) {
		return repository.findById(id).map(cliente -> {
			cliente.setNombre(newCliente.getNombre());
			return repository.save(cliente);
		}).orElseGet(() -> {
			newCliente.setId(id);
			return repository.save(newCliente);
		});
	}

	@DeleteMapping("/{id}")
	void deleteCliente(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	/*
	 * SECCION DE SERVICIOS ADICIONALES
	 */
	@GetMapping("/nombre/{nombre}")
	public Iterable<Cliente> getClientesByName(@PathVariable String nombre) {
		return repository.findAllByName(nombre);
	}
	/*
	 * FIN DE SECCION DE SERVICIOS ADICIONALES
	 */
}
