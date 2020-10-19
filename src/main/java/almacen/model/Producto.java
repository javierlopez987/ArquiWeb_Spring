package almacen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nombre;
	@Column
	private float costo;
	@Column
	private Integer stock;
	/*
	 * Atributo cuya función es permitir la navegación hacia Carrito y borrar en cascada
	 * cuando se le pasa determinado producto. Utilizado en el endpoint productos/{id}
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "producto")
	@JsonIgnore
	List<Carrito> ventas;
	
	public Producto() {
		super();
	}

	public Producto(String nombre, float costo, Integer stock) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.stock = stock;
	}

}
