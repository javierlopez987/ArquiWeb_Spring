package almacen.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Producto producto;
	@ManyToOne
	private Cliente cliente;
	@Column
	private Date fecha;
	@Column
	private Integer cantidad;
	@Column
	private float precio;
	
	public Carrito() {
		super();
	}

	public Carrito(Producto producto, Cliente cliente, String fecha, Integer cantidad, float precio) {
		super();
		this.producto = producto;
		this.cliente = cliente;
		this.fecha = Date.valueOf(fecha);
		this.cantidad = cantidad;
		this.precio = precio;
	}
}
