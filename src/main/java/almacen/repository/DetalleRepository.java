package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Detalle;
import almacen.model.Producto;

public interface DetalleRepository extends JpaRepository<Detalle,Long>{
	
	@Query("SELECT d FROM Detalle d where d.producto = :producto")
	public List<Detalle> findAllByProducto(Producto producto);
	
	@Query("SELECT d FROM Detalle d where d.cantidad = :cantidad")
	public List<Detalle> findAllByCantidad(Integer cantidad);

}
