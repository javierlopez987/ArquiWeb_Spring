package almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almacen.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	@Query("SELECT t FROM Cliente t where t.saldo >= :saldo")
    public List<Cliente> findAllBySaldoMayor(Float saldo);
	

    @Query("SELECT t FROM Cliente t where t.nombre = :name")
    public List<Cliente> findAllByName(String name);
	

}
