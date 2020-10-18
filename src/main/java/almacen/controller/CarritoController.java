package almacen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almacen.dto.ItemCompraDTO;
import almacen.model.Carrito;
import almacen.repository.CarritoRepository;
import almacen.repository.ClienteRepository;
import almacen.repository.ProductoRepository;

@RestController
@RequestMapping("compras")
public class CarritoController {

	@Autowired
	private final CarritoRepository repository;
	@Autowired
	private final ClienteRepository clienteRepository;
	@Autowired
	private final ProductoRepository productoRepository;

	public CarritoController(CarritoRepository repository, ClienteRepository clienteRepository,
			ProductoRepository productoRepository) {
		super();
		this.repository = repository;
		this.clienteRepository = clienteRepository;
		this.productoRepository = productoRepository;
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
	public ItemCompraDTO newCompra(@RequestBody Carrito c) {
		Carrito newCarrito = repository.save(c);
		return new ItemCompraDTO(newCarrito);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompra(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
