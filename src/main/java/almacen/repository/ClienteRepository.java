package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
    @Query("SELECT c FROM Cliente c where c.nombre = :nombre")
    public List<Cliente> findAllByName(String nombre);
	

}
