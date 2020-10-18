package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.dto.CompraClienteDTO;
import almacen.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
    @Query("SELECT c FROM Cliente c where c.nombre = :nombre")
    public List<Cliente> findAllByName(String nombre);
	
	@Query("SELECT new almacen.dto.CompraClienteDTO(c.nombre, SUM(ca.precio * ca.cantidad) AS total_compras) "
			+ "FROM Carrito AS ca JOIN ca.cliente c GROUP BY ca.cliente ORDER BY total_compras DESC")
	public List<CompraClienteDTO> selectTotalComprasClientes();
}
