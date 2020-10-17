package almacen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	@JsonIgnore
	private List<Carrito> compras;

	public Cliente() {
		super();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

}
