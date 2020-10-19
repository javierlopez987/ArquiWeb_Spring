package almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almacen.dto.CompraClienteDTO;
import almacen.dto.ProductoVendidoDTO;
import almacen.dto.VentasDTO;
import almacen.repository.CarritoRepository;
import almacen.repository.ClienteRepository;
import almacen.repository.ProductoRepository;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	@Autowired
	private final ClienteRepository clienteRepository;
	@Autowired
	private final CarritoRepository carritoRepository;
	@Autowired
	private final ProductoRepository productoRepository;

	public ReporteController(ClienteRepository clienteRepository, 
			CarritoRepository carritoRepository, ProductoRepository productoRepository) {
		super();
		this.clienteRepository = clienteRepository;
		this.carritoRepository = carritoRepository;
		this.productoRepository = productoRepository;
	}
	
	@GetMapping("/compras")
	public Iterable<CompraClienteDTO> getTotalComprasClientes() {
		return clienteRepository.selectTotalComprasClientes();
	}
	
	@GetMapping("/ventas")
	public Iterable<VentasDTO> getTotalVentasDiarias() {
		return carritoRepository.selectVentasDiarias();
	}
	
	@GetMapping("/productos")
	public Iterable<ProductoVendidoDTO> getProductoMasVendido() {
		return productoRepository.selectProductoMasVendido(PageRequest.of(0,1));
	}
}
