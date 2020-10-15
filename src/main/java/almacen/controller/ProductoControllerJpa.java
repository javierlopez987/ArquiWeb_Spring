package almacen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import almacen.model.Cliente;
import almacen.model.Producto;
import almacen.repository.ProductoRepository;

public class ProductoControllerJpa {
	
	@Qualifier("productoRepository")
	@Autowired
	private final ProductoRepository repository;

	public ProductoControllerJpa(@Qualifier("productoRepository") ProductoRepository repository) {
        this.repository = repository;
    }
	
	@GetMapping("/")
	public Iterable<Producto> getProductos(){
		return repository.findAll();
	}
	
	@GetMapping("/ByName/{name}")
	public Iterable<Producto> getProductosByName(@PathVariable String name) {
        return repository.findAllByName(name);
	} 
	
	 @GetMapping("/ByPrecio/{valor}")
		public Iterable<Producto> getProdcutosByValor(@PathVariable Float valor) {
	        return repository.findAllByValor(valor);
		} 
	 
	 @GetMapping("/{id}")
		Optional<Producto> one(@PathVariable Long id) {

	        return repository.findById(id);
	    }
	 
	 @PutMapping("/{id}")
		Producto replaceProducto(@RequestBody Producto newProducto, @PathVariable Long id) {
			
		        return repository.findById(id)
		                .map(producto -> {
		                    producto.setNombre(newProducto.getNombre());
		                    return repository.save(producto);
		                })
		                .orElseGet(() -> {
		                    producto.setSaldo(newProducto.getValor());
		                    return repository.save(newProducto);//ver bien este metodo
		                });
		    }
		
		@DeleteMapping("/{id}")
	    void deleteProducto(@PathVariable Long id) {
	        repository.deleteById(id);
	    }
}
