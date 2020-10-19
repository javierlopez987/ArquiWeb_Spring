package almacen.controller;

import java.util.List;
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
import almacen.model.Producto;
import almacen.repository.CarritoRepository;
import almacen.repository.ClienteRepository;
import almacen.repository.ProductoRepository;

@RestController
@RequestMapping("carritos")
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
		ItemCompraDTO ctrlItem = new ItemCompraDTO(c);
		List<Producto> prod = this.repository.findAllByCliente(c.getCliente(),c.getFecha());
		int cantProd = c.getCantidad(); 
		for (Producto p: prod) {
			if (p == c.getProducto()){
				cantProd++;
			}
		}
		if (cantProd < 4) {
		//TODO ctrlItem para control cupo diario por producto
		Carrito newCarrito = repository.save(c);
		return new ItemCompraDTO(newCarrito);
		}
		return null;
}
	
	@DeleteMapping("/{id}")
	public void deleteCompra(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
