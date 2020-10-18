package almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almacen.dto.CompraClienteDTO;
import almacen.repository.ClienteRepository;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	@Autowired
	private final ClienteRepository clienteRepository;

	public ReporteController(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping("/clientes/compras")
	public Iterable<CompraClienteDTO> getTotalComprasClientes() {
		return clienteRepository.selectTotalComprasClientes();
	}
}
