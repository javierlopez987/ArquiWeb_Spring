package almacen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import almacen.model.Carrito;
import almacen.repository.CarritoRepository;

@RestController
@RequestMapping("compras")
public class CarritoController {

	@Qualifier("carritoRepository")
	@Autowired
	private final CarritoRepository repository;

	public CarritoController(@Qualifier("carritoRepository") CarritoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public Iterable<Carrito> getCarritos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Carrito> getOne(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping("/")
	public void newCompra(@RequestBody Carrito c) {
		repository.save(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompra(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
