package almacen.model;

public class DetalleCarrito {
	
	private Long id_detalle;
	
	private Producto producto;
	
	private Integer cantidad;
	
	public DetalleCarrito() {
		super();
	}

	public DetalleCarrito(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
}
