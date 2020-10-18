package almacen.dto;

import java.io.Serializable;

import almacen.model.Carrito;
import lombok.Data;

@Data
public class ItemCompraDTO implements Serializable{

	private static final long serialVersionUID = 297901718994933395L;
	private Long id;
	private String fecha;
	private Long id_producto;
	private Long id_cliente;
	private Float precio;
	private Integer cantidad;
	
	@SuppressWarnings("deprecation")
	public ItemCompraDTO(Carrito c) {
		this.id = c.getId();
		this.fecha = c.getFecha().toGMTString();
		this.id_producto = c.getProducto().getId();
		this.id_cliente = c.getCliente().getId();
		this.precio = c.getPrecio();
		this.cantidad = c.getCantidad();
	}
	
	public Float getTotal() {
		return precio * cantidad;
	}
}
