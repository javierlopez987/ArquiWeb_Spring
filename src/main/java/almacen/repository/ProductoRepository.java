package almacen.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import almacen.dto.ProductoVendidoDTO;
import almacen.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
	
	@Query("SELECT p FROM Producto p where p.nombre = :name")
	public List<Producto> findAllByName(String name);
	
	/**
     * Consideramos más útil esta consulta que la de buscar por costo igual a un valor
	 * @param costo
	 * @return Lista productos cuyo costo es mayor al valor pasado por parametro
	 */
	@Query("SELECT p FROM Producto p where p.costo > :costo")
    public List<Producto> findAllGreaterThanCosto(float costo);
	
	/**
     * Consideramos más útil esta consulta que la de buscar por costo igual a un valor
	 * @param costo
	 * @return Lista productos cuyo costo es menor o igual el valor pasado por parametro
	 */
	@Query("SELECT p FROM Producto p where p.costo <= :costo")
    public List<Producto> findAllLessThanOrEqualCosto(float costo);

    /**
     * Consideramos más útil esta consulta que la de buscar por stock igual a un valor
     * @param stock
     * @return Lista productos cuyo stock es mayor al valor pasado por parametro
     */
    @Query("SELECT p FROM Producto p where p.stock > :stock")
    public List<Producto> findAllGreaterThanStock(Integer stock);
    
    /**
     * Consideramos más útil esta consulta que la de buscar por stock igual a un valor
     * @param stock
     * @return Lista productos cuyo stock es menor o igual que el valor pasado por parametro
     */
    @Query("SELECT p FROM Producto p where p.stock <= :stock")
    public List<Producto> findAllLessThanOrEqualStock(Integer stock);
    
	@Query("SELECT new almacen.dto.ProductoVendidoDTO(p.nombre, SUM(ca.cantidad) AS cantidad_vendida) "
			+ "FROM Carrito AS ca JOIN ca.producto p "
			+ "GROUP BY ca.producto "
			+ "ORDER BY cantidad_vendida DESC ")
	public List<ProductoVendidoDTO> selectProductoMasVendido(Pageable pageable);
}
