package almacen.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrito {
	
	@Id
	private Integer id;
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

	public List<Producto> getCompra() {
		return compra;
	}

	public void setCompra(List<Producto> compra) {
		this.compra = compra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", compra=" + compra + ", cliente=" + cliente + "]";
	}
	
	

}
