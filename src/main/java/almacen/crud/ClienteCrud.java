package almacen.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import almacen.model.Cliente;

@Repository
public interface ClienteCrud extends CrudRepository<Cliente,Long>{
	
	List<Cliente> findByNombre(String nombre);

}
