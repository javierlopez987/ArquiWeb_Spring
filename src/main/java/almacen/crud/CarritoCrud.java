package almacen.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import almacen.model.Carrito;
import almacen.model.Cliente;
import almacen.model.Producto;

@Repository
public interface CarritoCrud extends CrudRepository<Carrito, Long> {

    List<Carrito> findByCliente(Cliente cliente);
    
    List<Carrito> findByProducto(Producto producto);
    
}
