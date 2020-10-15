package almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Producto {

	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private Float valor;
	@Column
	private Integer stock;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String descripcion, Float valor, Integer stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.stock = stock;
	}

}
