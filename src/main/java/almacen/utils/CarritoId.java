package almacen.utils;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CarritoId implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id_producto;
	private int id_cliente;
	
	public CarritoId() {
		super();
	}

	public CarritoId(int id_producto, int id_cliente) {
		super();
		this.id_producto = id_producto;
		this.id_cliente = id_cliente;
	}
	
}
