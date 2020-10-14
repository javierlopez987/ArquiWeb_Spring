package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
	@Query("SELECT t FROM Producto t where t.valor >= :valor")
    public List<Producto> findAllByValor(Float valor);
	

    @Query("SELECT t FROM Producto t where t.name = :name")
    public List<Producto> findAllByName(String name);
    
    @Query("SELECT t FROM Producto t where t.stock = :stock")
    public List<Producto> findAllByStock(Integer stock);
    
}
