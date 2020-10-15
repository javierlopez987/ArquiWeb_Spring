package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Carrito;
import almacen.model.Producto;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{

    @Query("SELECT t FROM Carrito t where t.cliente = :cliente")
    public List<Producto> findAllByName(String name);
    
    
    
    
}
