package almacen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Float saldo;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, Float saldo) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
}
