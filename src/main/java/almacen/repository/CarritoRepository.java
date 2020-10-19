package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.dto.VentasDTO;
import almacen.model.Carrito;
import almacen.model.Cliente;
import almacen.model.Producto;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{

    @Query("SELECT c FROM Carrito c where c.cliente = :cliente")
    public List<Producto> findAllByCliente(Cliente cliente);
    
	@Query("SELECT new almacen.dto.VentasDTO(ca.fecha, SUM(ca.cantidad) AS cantidad_productos, SUM(ca.precio * ca.cantidad) AS total_ventas) "
			+ "FROM Carrito AS ca GROUP BY ca.fecha ORDER BY ca.fecha DESC")
	public List<VentasDTO> selectVentasDiarias();
    
}
