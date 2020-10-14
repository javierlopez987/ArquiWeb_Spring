package almacen.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import almacen.model.Producto;

@Repository
public interface ProductoCrud extends CrudRepository<Producto,Long>{
	
	 
	

}
