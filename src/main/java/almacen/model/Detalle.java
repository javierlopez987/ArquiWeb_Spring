package almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Detalle {
	@Id
	private Long id_detalle;
	@Column
	private Producto producto;
	@Column
	private Integer cantidad;
	
	public Detalle() {
		super();
	}

	public Detalle(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
