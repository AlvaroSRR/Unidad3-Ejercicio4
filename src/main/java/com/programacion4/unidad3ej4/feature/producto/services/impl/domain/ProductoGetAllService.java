package main.java.com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import java.util.List;

import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;

@Service
@AllArgsConstructor
public class ProductoGetAllService {
        
    private final IProductoRepository productoRepository = null;

    public List<ProductoResponseDto> getAll() {

        List<Producto> productos = productoRepository.findByEstaEliminadoFalse();

        return productos.stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }
}
