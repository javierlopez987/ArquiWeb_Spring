package almacen.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany
	private Collection<Detalle> detalles;
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

	public Carrito(Collection<Detalle> detalles, Cliente cliente, String fecha, Integer cantidad, float precio) {
		super();
		this.detalles = detalles;
		this.cliente = cliente;
		this.fecha = Date.valueOf(fecha);
		this.cantidad = cantidad;
		this.precio = precio;
	}
}
