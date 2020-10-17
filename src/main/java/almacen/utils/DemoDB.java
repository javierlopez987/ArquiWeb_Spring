package almacen.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import almacen.model.Cliente;
import almacen.repository.ClienteRepository;

@Configuration
public class DemoDB {
	
	@Bean
    CommandLineRunner initDatabase(@Qualifier("clienteRepository") ClienteRepository repository) {
        return args -> {
            repository.save(new Cliente("Pedro"));
            repository.save(new Cliente("Pablo"));
        };
    }
}
