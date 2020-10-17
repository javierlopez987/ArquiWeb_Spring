package almacen.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import almacen.model.Cliente;
import almacen.model.Producto;
import almacen.repository.ClienteRepository;
import almacen.repository.ProductoRepository;

@Configuration
public class DemoDB {

	@Bean
	CommandLineRunner initDatabase(@Qualifier("clienteRepository") ClienteRepository clienteRepository,
			@Qualifier("productoRepository") ProductoRepository productoRepository) {
		return args -> {
			clienteRepository.save(new Cliente("Pedro"));
			clienteRepository.save(new Cliente("Pablo"));
			productoRepository.save(new Producto("Marmol", 15.50f, 100));
			productoRepository.save(new Producto("Caliza", 10.50f, 200));
			productoRepository.save(new Producto("Granito", 8.50f, 500));
			productoRepository.save(new Producto("Cuarcita", 12.50f, 350));
		};
	}
}
