package almacen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Carrito {
	
	@Id
	private Long id;
	@Column
	private List<Producto> compra;
	@Column
	private Cliente cliente;
	
	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito(List<Producto> compra, Cliente cliente) {
		super();
		this.compra = compra;
		this.cliente = cliente;
	}

}
