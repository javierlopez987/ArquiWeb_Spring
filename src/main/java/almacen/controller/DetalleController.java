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

import almacen.model.Cliente;
import almacen.model.Detalle;
import almacen.repository.ClienteRepository;
import almacen.repository.DetalleRepository;

public class DetalleController {
	@Qualifier("clienteRepository")
	@Autowired
	private final DetalleRepository repository;

	public DetalleController(@Qualifier("detalleRepository") DetalleRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public Iterable<Detalle> getDetalle() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Detalle> one(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping("/")
	public Detalle newDetalle(@RequestBody Detalle d) {
		return repository.save(d);
	}

	@PutMapping("/{id}")
	Detalle replaceDetalle(@RequestBody Detalle newDetalle, @PathVariable Long id) {
		return repository.findById(id).map(detalle -> {
			detalle.setProducto(newDetalle.getProducto());
			detalle.setCantidad(newDetalle.getCantidad());
			return repository.save(detalle);
		}).orElseGet(() -> {
			newDetalle.setId(id);
			return repository.save(newDetalle);
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
