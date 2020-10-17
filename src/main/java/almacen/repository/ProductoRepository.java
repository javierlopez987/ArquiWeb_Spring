package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
	@Query("SELECT p FROM Producto p where p.costo >= :costo")
    public List<Producto> findAllByCosto(float costo);

    @Query("SELECT p FROM Producto p where p.nombre = :name")
    public List<Producto> findAllByName(String name);
    
    @Query("SELECT p FROM Producto p where p.stock >= :stock")
    public List<Producto> findAllByStock(Integer stock);
    
}
