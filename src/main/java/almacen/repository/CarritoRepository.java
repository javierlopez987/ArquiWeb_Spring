package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Carrito;
import almacen.model.Cliente;
import almacen.model.Producto;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{

    @Query("SELECT c FROM Carrito c where c.cliente = :cliente")
    public List<Producto> findAllByCliente(Cliente cliente);
    
    
}
