package almacen.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import almacen.model.Producto;

@Repository
public interface ProductoCrud extends CrudRepository<Producto,Long>{
	
	 
	List<Producto> findByName(String name);
	
	List<Producto> findByValor(Float valor);
	
	


}