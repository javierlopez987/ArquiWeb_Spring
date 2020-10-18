package almacen.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDTO implements Serializable {

	private static final long serialVersionUID = 4004289316943616324L;
	private Long id;
	private String fecha;
	private String producto;
	private String cliente;
	private Float precio;
	private Integer cantidad;
	private Float total;

}
