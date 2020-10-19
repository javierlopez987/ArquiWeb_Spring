package almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almacen.dto.CompraClienteDTO;
import almacen.dto.VentasDTO;
import almacen.repository.CarritoRepository;
import almacen.repository.ClienteRepository;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	@Autowired
	private final ClienteRepository clienteRepository;
	@Autowired
	private final CarritoRepository carritoRepository;

	public ReporteController(ClienteRepository clienteRepository, CarritoRepository carritoRepository) {
		super();
		this.clienteRepository = clienteRepository;
		this.carritoRepository = carritoRepository;
	}
	
	@GetMapping("/compras")
	public Iterable<CompraClienteDTO> getTotalComprasClientes() {
		return clienteRepository.selectTotalComprasClientes();
	}
	
	@GetMapping("/ventas")
	public Iterable<VentasDTO> getTotalVentasDiarias() {
		return carritoRepository.selectVentasDiarias();
	}
}
